package com.workflow86.service;

import com.workflow86.util.StringUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Stream;

import static com.workflow86.util.StringUtil.*;

public class JsonService {
    private final String jsonString;

    public JsonService(String jsonString) {
        this.jsonString = jsonString;
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
    public String fixInCompleteJSON() {
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
            fixedJson.append(jc);
        }

        if (bracketStack.size() == 1 && isOpenCurlyBracket(bracketStack.pop())) {
            fixedJson.append('}');
        }
        return fixDoubleQuoteAndComma(fixedJson.toString());
    }

    public String fixDoubleQuoteAndComma(String json) {
        StringBuilder fixedJSON = new StringBuilder();
        Stream<String> linesStream = Arrays.stream(json.split("\\n"));
        linesStream.forEach(line -> {
            String trimmedLine = line.trim();
            long noOfDoubleQuote = trimmedLine.chars().filter(StringUtil::isDoubleQuote).count();
            long noOColon = trimmedLine.chars().filter(StringUtil::isColon).count();
            if (trimmedLine.length() == 1 && isBracket(trimmedLine.charAt(0))) {
                fixedJSON.append(trimmedLine).append(System.lineSeparator());
            } else if (noOfDoubleQuote == 4 && noOColon == 1) {
                fixedJSON.append(trimmedLine).append(System.lineSeparator());
            } else if ((noOfDoubleQuote < 4 && noOfDoubleQuote > 1)) {
                String fixedDoubleQuotes = fixDoubleQuote(trimmedLine);
                fixedJSON.append(fixedDoubleQuotes).append(System.lineSeparator());
            }
        });
        return fixedJSON.toString();
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
            fixedQuote.append("\",");
        }

        return fixedQuote.toString();
    }
}
