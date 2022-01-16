package com.anas.code;

import com.anas.code.enums.LineSeparator;

public class DocumentManger {
    private String text;
    private int totalNumOfLines, currentLineNum;
    private String path;
    private LineSeparator lineSeparator;
    private int currentIndex;

    public DocumentManger(String text, LineSeparator defaultLineSeparator) {
        if (text != null) {
            this.text = text;
            this.lineSeparator = defaultLineSeparator; // todo: Get the line separator from the file
        } else {
            this.text = "";
            lineSeparator = defaultLineSeparator;
        }
        this.path = "";
        currentLineNum = 1;
        currentIndex = 0;
        updateTotalNumOfLines();
    }

    public void addChar(char c) {
        text = text.substring(0, currentIndex) + c + text.substring(currentIndex);
        currentIndex++;
    }

    public void removeCharacter() {
        if (text.length() > 0) {
            if (text.charAt(text.length() - 1) == lineSeparator.separator.charAt(0)) {
                if (lineSeparator.separator.length() > 1) {
                    if (text.charAt(text.length() - 2) == lineSeparator.separator.charAt(1)) {
                        text = text.substring(0, currentIndex - 2) + text.substring(currentIndex - 1);
                    }
                }  else {
                    text = text.substring(0, currentIndex - 1) + text.substring(currentIndex);
                }
                currentLineNum--;
            }
            text = text.substring(0, currentIndex - 1) + text.substring(currentIndex);
            decrementCurrentIndex();
        }
    }

    public void addNewLine() {
        text += lineSeparator.separator;
        updateTotalNumOfLines();
        currentLineNum++;
        System.out.println("currentLineNum = " + currentLineNum);
    }

    private void updateTotalNumOfLines() {
        totalNumOfLines = 1; // reset
        for (char c : text.toCharArray()) {
            if (c == lineSeparator.separator.charAt(0)) {
                if (lineSeparator.separator.length() > 1) {
                    if (c == lineSeparator.separator.charAt(1)) {
                        totalNumOfLines++;
                    }
                } else {
                    totalNumOfLines++;
                }
            }
        }
    }

    public String getCurrentLine() {
        var line = "";
        try {
            line = text.lines().toList().get(currentLineNum - 1);
        } catch (IndexOutOfBoundsException ignored) {}

        return line;
    }

    public boolean contentCode() {
        return text.length() > 0;
    }

    // getters
    public String getText() {
        return text;
    }
    public int getTotalNumOfLines() {
        return totalNumOfLines;
    }
    public int getCurrentLineNum() {
        return currentLineNum;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void incrementCurrentLineNum() {
        if (currentLineNum < totalNumOfLines) {
            currentLineNum++;
            // Update current index
            currentIndex = text.lines().toList().get(currentLineNum - 1).length();
        }
    }

    public void decrementCurrentLineNum() {
        if (currentLineNum > 1) {
            currentLineNum--;
            // Update current index
            currentIndex = text.lines().toList().get(currentLineNum - 1).length();
        }
    }

    public int decrementCurrentIndex() {
        if (currentIndex > 0) {
            currentIndex--;
        }
        return currentIndex;
    }

    public int incrementCurrentIndex() {
        if (currentIndex < text.length()) {
            currentIndex++;
        }
        return currentIndex;
    }

}
