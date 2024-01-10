package com.workflow86.service;

import com.workflow86.util.StringUtil;

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

        for (char jc : jsonChars) {
            if (isOpenCurlyBracketOrOpenSquareBracket(jc)) {
                characterStack.push(jc);
            } else if (isCloseCurlyBracketOrCloseSquareBracket(jc)) {
                if (characterStack.isEmpty()) {
                    return false;
                }
                char firstInStack = characterStack.pop();
                if ((isCloseCurlyBracket(jc) && !isOpenCurlyBracket(firstInStack)) || (isCloseSquareBracket(jc) && !isOpenSquareBracket(firstInStack))) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    /**
     * 1. Add missing brackets
     * 2. Remove uncompleted fields
     * 3. Add correct double quotes
     * 4. Remove extra comma
     *
     * @return
     */
    public String fixIncompleteJSON() {
        if (isValidJSON()) {
            return jsonString;
        }
        StringBuilder fixedJson = new StringBuilder();
        Deque<Character> bracketStack = new ArrayDeque<>();

        char[] jsonChars = jsonString.toCharArray();
        for (char jc : jsonChars) {
            if (isOpenCurlyBracketOrOpenSquareBracket(jc)) {
                bracketStack.push(jc);
            }

            if (isCloseCurlyBracket(jc) && isOpenCurlyBracket(bracketStack.peek())) {
                bracketStack.pop();
            }

            if (isCloseSquareBracket(jc) && isOpenSquareBracket(bracketStack.peek())) {
                bracketStack.pop();
            }

            fixedJson.append(jc);
        }

        if (bracketStack.size() == 1 && isOpenCurlyBracket(bracketStack.pop())) {
            fixedJson.append(System.lineSeparator()).append('}');
        }
        for (char element : bracketStack) {
            if (isOpenSquareBracket(element)) {
                fixedJson.append(System.lineSeparator()).append(']');
            }
            if (isOpenCurlyBracket(element)) {
                fixedJson.append(System.lineSeparator()).append('}');
            }
        }
        return fixDoubleQuotesAndCommas(fixedJson.toString());
    }

    public String fixDoubleQuotesAndCommas(String json) {
        List<String> fixedJSON = new ArrayList<>();
        String[] jsonByLines = json.split("\\n");
        for (int i = 0; i < jsonByLines.length; i++) {
            String trimmedLine = jsonByLines[i].trim();

            long noOfDoubleQuote = trimmedLine.chars().filter(StringUtil::isDoubleQuote).count();
            long noOColon = trimmedLine.chars().filter(StringUtil::isColon).count();
//            Fix brackets
            if ((trimmedLine.length() == 1 || trimmedLine.length() == 2) && isBracket(trimmedLine.charAt(0))) {
                if (isCloseCurlyBracketOrCloseSquareBracket(trimmedLine.charAt(0))) {
                    removeCommaFromPrevLastField(fixedJSON);
                }
                fixedJSON.add(trimmedLine);
//                Adding correct fields
            } else if (noOfDoubleQuote == 4 && (noOColon >= 1 || trimmedLine.contains("://"))) {
                String fixedDoubleQuotes = getQuoteCorrectedLastField(trimmedLine, jsonByLines, i);
                fixedJSON.add(fixedDoubleQuotes);
            } else if ((noOfDoubleQuote < 4 && noOfDoubleQuote > 1)) {
                String fixedDoubleQuotes = fixDoubleQuote(trimmedLine);
                String correctedLastField = getQuoteCorrectedLastField(fixedDoubleQuotes, jsonByLines, i);
                String booleanCorrectedField = correctBooleanValues(correctedLastField);
                fixedJSON.add(booleanCorrectedField);
            }
        }
        return String.join(System.lineSeparator(), fixedJSON);
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
        return i < jsonByLines.length - 1 && !jsonByLines[i + 1].isEmpty() && isCloseCurlyBracketOrCloseSquareBracket(jsonByLines[i + 1].trim().charAt(0));
    }

    private void removeCommaFromPrevLastField(List<String> fixedJSON) {
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
        char firstChar = jsonField.charAt(0);
        if (!isDoubleQuote(firstChar)) {
            fixedQuote.insert(0, '"');
        }

        char lastChar = jsonField.charAt(jsonField.length() - 1);
        if (isDoubleQuote(lastChar)) {
            fixedQuote.append(',');
        }

        if (!isDoubleQuote(lastChar) && !isComma(lastChar)) {
            if (Character.isDigit(lastChar)) {
                fixedQuote.append(",");
            } else {
                if (!isOpenCurlyBracketOrOpenSquareBracket(lastChar)) {
                    fixedQuote.append("\",");
                }
            }
        }
        return fixedQuote.toString();
    }
}
