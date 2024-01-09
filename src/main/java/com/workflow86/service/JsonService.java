package com.workflow86.service;

import java.util.ArrayDeque;
import java.util.Deque;

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
            if (isOpenCurlyBracket(jc) || isOpenSquareBracket(jc)) {
                characterStack.push(jc);
            } else if (isCloseCurlyBracket(jc) || isCloseSquareBracket(jc)) {
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
}
