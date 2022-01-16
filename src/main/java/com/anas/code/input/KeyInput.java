package com.anas.code.input;

import com.anas.code.EditorPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    private EditorPanel editorPanel;
    private int keyCode;

    // Constructor
    public KeyInput(EditorPanel editorPanel) {
        this.editorPanel = editorPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // If the key typed is a backspace
        if (keyCode == KeyEvent.VK_BACK_SPACE || keyCode == KeyEvent.VK_DELETE) {
            // Remove the last character from the text
            editorPanel.getCode().removeCharacter();
            System.out.println("Backspace");
        } else if (keyCode == KeyEvent.VK_ENTER) { // If the key typed is an enter
            // Add a new line to the text
            editorPanel.getCode().addNewLine();
        } else {
            editorPanel.getCode().addChar(e.getKeyChar());
            // Print the key that was typed to the console
        }
        System.out.println(e.getKeyChar());

        System.out.println("keyCode = " + keyCode);

        // repaint the editor panel
        editorPanel.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyCode = e.getKeyCode(); // Get the key code

        // If the key pressed is a arrow key (cursor movement)
        if (keyCode == KeyEvent.VK_LEFT) {
            // Move the cursor to the left
            editorPanel.moveCursorToLeft();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // Move the cursor to the right
            editorPanel.moveCursorToRight();
        } else if (keyCode == KeyEvent.VK_UP) {
            // Move the cursor to the up
            editorPanel.moveCursorToUp();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            // Move the cursor to the down
            editorPanel.moveCursorToDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
