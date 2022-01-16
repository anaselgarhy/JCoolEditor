package com.anas.code.highlighter.keywords;

import java.awt.*;

public class KeywordsCollection {
    private Color color;
    private String[] keywords;

    public KeywordsCollection(Color color, String[] keywords) {
        this.color = color;
        this.keywords = keywords;
    }

    public Color getColor() {
        return color;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public boolean contains(String word) {
        for (String keyword : keywords) {
            if (keyword.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
