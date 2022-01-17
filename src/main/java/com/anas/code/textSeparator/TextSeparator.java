package com.anas.code.textSeparator;

public class TextSeparator {
    private char splitter;

    public TextSeparator(char splitter) {
        this.splitter = splitter;
    }

    public char getSplitter() {
        return splitter;
    }

    public boolean isSeparator(char c) {
        return c == splitter;
    }
}