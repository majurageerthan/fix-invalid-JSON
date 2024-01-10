package com.workflow86.util;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isOpenCurlyBracket(char c) {
        return c == '{';
    }

    public static boolean isCloseCurlyBracket(char c) {
        return c == '}';
    }

    public static boolean isOpenSquareBracket(char c) {
        return c == '[';
    }

    public static boolean isCloseSquareBracket(char c) {
        return c == ']';
    }

    public static boolean isDoubleQuote(char c) {
        return c == '"';
    }

    public static boolean isDoubleQuote(int c) {
        return c == '"';
    }

    public static boolean isComma(char c) {
        return c == ',';
    }

    public static boolean isColon(int c) {
        return c == ':';
    }

    public static boolean isOpenCurlyBracketOrOpenSquareBracket(char c) {
        return isOpenCurlyBracket(c) || isOpenSquareBracket(c);
    }

    public static boolean isCloseCurlyBracketOrCloseSquareBracket(char c) {
        return isCloseCurlyBracket(c) || isCloseSquareBracket(c);
    }

    public static boolean isBracket(char c) {
        return isOpenCurlyBracketOrOpenSquareBracket(c) || isCloseCurlyBracketOrCloseSquareBracket(c);
    }
    public static String removeSpaces(String input) {
        return input.replaceAll("\\s", "");
    }
}
