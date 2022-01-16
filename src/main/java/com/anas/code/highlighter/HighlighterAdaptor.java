package com.anas.code.highlighter;

import com.anas.code.highlighter.keywords.KeywordsCollection;

import java.awt.Color;
import java.util.ArrayList;

public abstract class HighlighterAdaptor implements Highlighter{
    private KeywordsCollection[] collections;
    private Color defaultColor;

    // Constructor
    public HighlighterAdaptor() {
        initializeCollections();
        initializeDefaultColor();
    }

    // Abstract methods
    protected abstract void initializeCollections();

    protected abstract void initializeDefaultColor();

    protected WordHighlighted getHighlightedWordAdaptor(String word) {
        // Get the valid collections
        KeywordsCollection[] validCollections = validateCollections();

        // Get the highlighted string
        WordHighlighted highlightedString = new WordHighlighted(word, defaultColor);

        for (int i = 0; i < validCollections.length; i++) {
            if(validCollections[i].contains(word)) {
                highlightedString.setColor(validCollections[i].getColor());
                break;
            }
        }

        return highlightedString;
    }

    // Validate collections (get the valid collections)
    protected KeywordsCollection[] validateCollections() {
        ArrayList<KeywordsCollection> validCollections = new ArrayList<>();

        // Get the valid collections (if not null and not empty its valid)
        for (int i = 0; i < collections.length; i++) {
            if (collections[i] != null && collections[i].getKeywords().length > 0) {
                validCollections.add(collections[i]);
            }
        }

        return validCollections.toArray(new KeywordsCollection[0]);
    }

    // Getter and Setter methods
    public KeywordsCollection[] getCollections() {
        return collections;
    }

    public void setCollections(KeywordsCollection[] collections) {
        this.collections = collections;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }
}
