package com.anas.code.highlighter.highlighters;

import com.anas.code.highlighter.HighlighterAdaptor;
import com.anas.code.highlighter.WordHighlighted;
import com.anas.code.highlighter.keywords.KeywordsCollection;

import java.awt.*;

public class JavaHighlighter extends HighlighterAdaptor {

    private KeywordsCollection simpleKeywords; // Like "int" "if" etc.
    private KeywordsCollection complexKeywords; // Likee a multi-line comment or a class
    private KeywordsCollection textKeywords; // A string literal like "Hello World" or 'H'
    private KeywordsCollection commentKeywords; // A single line comment like //

    @Override
    protected void initializeCollections() {
        // Initialize the keywords
        initializeKeywords();
        // Initialize the collections
        super.setCollections(new KeywordsCollection[] {
                simpleKeywords,
                complexKeywords,
                textKeywords,
                commentKeywords,
        });
    }

    @Override
    protected void initializeDefaultColor() {
        super.setDefaultColor(new Color(255,255,255));
    }

    @Override
    public WordHighlighted highlight(String word) {
        return super.getHighlightedWordAdaptor(word);
    }

    // Initialize the keywords
    private void initializeKeywords() {
        simpleKeywords = new KeywordsCollection(new Color(248,121,169),  getAllSimpleKeywordsInJava());
    }

    private String[] getAllSimpleKeywordsInJava() {
        // Array of keywords in java
        return new String[] {
                "abstract", "assert", "boolean", "byte",
                "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else",
                "enum", "extends", "false", "final", "finally",
                "float", "for", "goto", "if", "implements",
                "import", "instanceof", "int", "interface", "long",
                "native", "new", "package", "private", "protected",
                "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw",
                "throws", "transient", "true", "try", "void", "volatile",
                "while",
        };
    }
}
