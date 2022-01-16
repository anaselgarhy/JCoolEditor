package com.anas.code.highlighter;

import java.awt.Color;

public class WordHighlighted {
    private String word;
    private Color color;

    // Constructor
    public WordHighlighted(String word, Color color) {
        setWord(word);
        setColor(color);
    }

    // Getters
    public String getWord() {
        return word;
    }

    public Color getColor() {
        return color;
    }

    // Setters
    public void setWord(String word) {
        this.word = word;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
