package com.anas.code;

import com.anas.code.highlighter.highlighters.JavaHighlighter;

import javax.swing.*;

public class Window extends JFrame {

    // Constructor
    public Window(EditorPanel editorPanel) {
        // Set the title
        setTitle("Simple java editor");
        // Disable the resize option
        setResizable(false);
        // Add the editor panel to the window
        add(editorPanel);
        // Set the size of the window
        setSize(editorPanel.getSize());
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the window to be visible
        setVisible(true);
    }

    // Test main
    public static void main(String[] args) {
        // Create an editor panel
        EditorPanel editorPanel = new EditorPanel();
        // Create a window
        //Window window = new Window(editorPanel);

        String javaCode = "public class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello World\"); } }";
        System.out.println(javaCode);
        System.out.println("----------------------------------------------------");

        String[] words = javaCode.split(" ");
        for (String word : words) {
            System.out.println(new JavaHighlighter().highlight(word).getColor().toString());
        }
    }
}
