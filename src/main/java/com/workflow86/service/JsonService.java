package com.workflow86.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.workflow86.util.StringUtil.*;

public class JsonService {
    private final String jsonString;

    public JsonService(String jsonString) {
        this.jsonString = jsonString.trim();
    }

    public boolean isValidJSON() {
        Deque<Character> characterStack = new ArrayDeque<>();
        char[] jsonChars = jsonString.toCharArray();

        for (char currentChar : jsonChars) {
            if (isOpenBracket(currentChar)) {
                characterStack.push(currentChar);
            } else if (isCloseBracket(currentChar) && (!handleClosingBracket(characterStack, currentChar))) {
                return false;
            }
        }
        return characterStack.isEmpty();
    }

    /**
     * 1. Add missing brackets
     * 2. Remove uncompleted fields
     * 3. Add correct double quotes
     * 4. Remove extra comma
     */
    public String fixIncompleteJSON() {
        if (isValidJSON()) {
            return jsonString;
        }

        StringBuilder fixedJson = new StringBuilder();
        Deque<Character> bracketStack = new ArrayDeque<>();

        char[] jsonChars = jsonString.toCharArray();

        for (char jc : jsonChars) {
            handleOpenBrackets(jc, bracketStack);
            appendCharacterAndCheckClosingBrackets(fixedJson, jc, bracketStack);
        }

        appendRemainingClosingBrackets(fixedJson, bracketStack);

        return fixDoubleQuotesAndCommas(fixedJson.toString());
    }

    public String fixDoubleQuotesAndCommas(String json) {
        List<String> fixedJSON = new ArrayList<>();
        String[] jsonByLines = json.split("\\n");
        for (int i = 0; i < jsonByLines.length; i++) {
            String trimmedLine = jsonByLines[i].trim();

            long noOfDoubleQuote = countOccurrences(trimmedLine, '"');
            long noOfColon = countOccurrences(trimmedLine, ':');

            if (isSingleBracket(trimmedLine)) {
                handleSingleBracket(fixedJSON, trimmedLine);
            } else if (isQuotedField(noOfDoubleQuote, noOfColon, trimmedLine)) {
                String fixedDoubleQuotes = getQuoteCorrectedLastField(trimmedLine, jsonByLines, i);
                fixedJSON.add(fixedDoubleQuotes);
            } else if (isIncompleteQuotedField(noOfDoubleQuote)) {
                processIncompleteQuotedField(fixedJSON, trimmedLine, jsonByLines, i);
            }
        }
        return String.join(System.lineSeparator(), fixedJSON);
    }

    private boolean isSingleBracket(String line) {
        return (line.length() == 1 || line.length() == 2) && isBracket(line.charAt(0));
    }

    private void handleSingleBracket(List<String> fixedJSON, String line) {
        if (isCloseBracket(line.charAt(0))) {
            removeCommaFromPreviousField(fixedJSON);
        }
        fixedJSON.add(line);
    }

    private boolean isQuotedField(long noOfDoubleQuote, long noOfColon, String line) {
        return noOfDoubleQuote == 4 && (noOfColon >= 1 || line.contains("://"));
    }

    private boolean isIncompleteQuotedField(long noOfDoubleQuote) {
        return noOfDoubleQuote < 4 && noOfDoubleQuote > 1;
    }

    private void processIncompleteQuotedField(List<String> fixedJSON, String trimmedLine, String[] jsonByLines, int i) {
        String fixedDoubleQuotes = fixDoubleQuote(trimmedLine);
        String correctedLastField = getQuoteCorrectedLastField(fixedDoubleQuotes, jsonByLines, i);
        String booleanCorrectedField = correctBooleanValues(correctedLastField);
        fixedJSON.add(booleanCorrectedField);
    }

    private boolean handleClosingBracket(Deque<Character> characterStack, char closingBracket) {
        if (characterStack.isEmpty()) {
            return false;
        }

        char openingBracket = characterStack.pop();
        return isMatchingBracket(openingBracket, closingBracket);
    }

    private void handleOpenBrackets(char jc, Deque<Character> bracketStack) {
        if (isOpenBracket(jc)) {
            bracketStack.push(jc);
        } else if (isCloseBracket(jc)) {
            char topChar = bracketStack.peek();
            if (isMatchingBracket(topChar, jc)) {
                bracketStack.pop();
            }
        }
    }

    private void appendCharacterAndCheckClosingBrackets(StringBuilder fixedJson, char jc, Deque<Character> bracketStack) {
        fixedJson.append(jc);

        if (isCloseBracket(jc)) {
            char element = bracketStack.peek();
            if (isMatchingBracket(element, jc)) {
                bracketStack.pop();
            }
        }
    }

    private void appendRemainingClosingBrackets(StringBuilder fixedJson, Deque<Character> bracketStack) {
        while (!bracketStack.isEmpty()) {
            char element = bracketStack.pop();
            appendNewLineAndClosingBracket(fixedJson, element);
        }
    }

    private void appendNewLineAndClosingBracket(StringBuilder fixedJson, char element) {
        if (isOpenSquareBracket(element)) {
            fixedJson.append(System.lineSeparator()).append(']');
        } else if (isOpenCurlyBracket(element)) {
            fixedJson.append(System.lineSeparator()).append('}');
        }
    }


    private String correctBooleanValues(String boolString) {
        return boolString.replace("false\"", "false").replace("true\"", "true");
    }

    private String getQuoteCorrectedLastField(String fixedDoubleQuotes, String[] jsonByLines, int i) {
        String lastFieldCorrected = fixedDoubleQuotes;
        if (isLastField(jsonByLines, i)) {
            lastFieldCorrected = fixedDoubleQuotes.replace(",", "");
        }
        return lastFieldCorrected;
    }


    private boolean isLastField(String[] jsonByLines, int i) {
        return i < jsonByLines.length - 1 && !jsonByLines[i + 1].isEmpty() && isCloseBracket(jsonByLines[i + 1].trim().charAt(0));
    }

    private void removeCommaFromPreviousField(List<String> fixedJSON) {
        int lastIndex = fixedJSON.size() - 1;
        if (lastIndex > 0) {
            String lastField = fixedJSON.get(lastIndex).trim();
            if (!lastField.isEmpty()) {
                String prevField = fixedJSON.get(lastIndex).replace(",", "");
                fixedJSON.set(lastIndex, prevField);
            }
        }
    }

    private String fixDoubleQuote(String jsonField) {
        StringBuilder fixedQuote = new StringBuilder(jsonField);

        ensureLeadingDoubleQuote(fixedQuote);
        appendCommaIfTrailingDoubleQuote(fixedQuote);
        appendCommaIfNeeded(fixedQuote);

        return fixedQuote.toString();
    }

    private void ensureLeadingDoubleQuote(StringBuilder fixedQuote) {
        if (!startsWithDoubleQuote(fixedQuote)) {
            fixedQuote.insert(0, '"');
        }
    }

    private boolean startsWithDoubleQuote(StringBuilder fixedQuote) {
        return !fixedQuote.isEmpty() && isDoubleQuote(fixedQuote.charAt(0));
    }

    private void appendCommaIfTrailingDoubleQuote(StringBuilder fixedQuote) {
        if (endsWithDoubleQuote(fixedQuote)) {
            fixedQuote.append(',');
        }
    }

    private boolean endsWithDoubleQuote(StringBuilder fixedQuote) {
        return !fixedQuote.isEmpty() && isDoubleQuote(fixedQuote.charAt(fixedQuote.length() - 1));
    }

    private void appendCommaIfNeeded(StringBuilder fixedQuote) {
        char lastChar = fixedQuote.charAt(fixedQuote.length() - 1);

        if (!isDoubleQuote(lastChar) && !isComma(lastChar)) {
            if (Character.isDigit(lastChar)) {
                fixedQuote.append(",");
            } else {
                appendCommaBeforeNonBracket(fixedQuote, lastChar);
            }
        }
    }

    private void appendCommaBeforeNonBracket(StringBuilder fixedQuote, char lastChar) {
        if (!isOpenBracket(lastChar)) {
            fixedQuote.append("\",");
        }
    }
}
