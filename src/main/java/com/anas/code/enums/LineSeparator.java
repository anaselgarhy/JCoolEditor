package com.anas.code.enums;

public enum LineSeparator {
    LF("\n"),
    CRLF("\r\n"),
    CR("\r");

    public final String separator;

    LineSeparator(String separator) {
        this.separator = separator;
    }
}
