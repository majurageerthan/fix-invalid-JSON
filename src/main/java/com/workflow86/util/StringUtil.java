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

    public static boolean isMatchingBracket(char opening, char closing) {
        return (opening == '{' && closing == '}') || (opening == '[' && closing == ']');
    }

    public static boolean isOpenBracket(char c) {
        return isOpenCurlyBracket(c) || isOpenSquareBracket(c);
    }

    public static boolean isCloseBracket(char c) {
        return isCloseCurlyBracket(c) || isCloseSquareBracket(c);
    }

    public static boolean isBracket(char c) {
        return isOpenBracket(c) || isCloseBracket(c);
    }

    public static long countOccurrences(String line, char character) {
        return line.chars().filter(c -> c == character).count();
    }
}
