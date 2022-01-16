package com.anas.code;

import com.anas.code.enums.LineSeparator;
import com.anas.code.input.KeyInput;
import com.anas.code.input.MouseInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorPanel extends JPanel implements ActionListener, Scrollable {
    private DocumentManger code;
    private int width, height;
    private int fontSize;  // font size of the text
    private boolean wrap; // whether the text should wrap
    private Timer timer; // timer for the animation
    private boolean cursorOn; // whether the cursor is on
    private LineSeparator lineSeparator; // line separator
    JTextArea textArea;

    // Constructor
    public EditorPanel() {
        init();

        // Set focus to the editor
        setFocusable(true);

        super.setPreferredSize(new Dimension(width, height));

        // Add key listener
        addKeyListener(new KeyInput(this));

        // Add mouse listener
        addMouseListener(new MouseInput(this));

        // Set the cursor shape
        setCursor(new Cursor(Cursor.TEXT_CURSOR));

        // Start the timer
        timer.start();
    }
     private void init() {
        lineSeparator = LineSeparator.LF;
        code = new DocumentManger(null, lineSeparator);
         width = 500;
         height = 550;
         fontSize = 20;
         wrap = true;
         timer = new Timer(500, this);
         cursorOn = false;
     }

     @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
     }

     private void draw(Graphics g) {
        // Draw the background
         g.setColor(Color.BLACK);
         g.fillRect(0, 0, width, height);

         // Set the font
         //g.setFont(new Font("Courier New", Font.PLAIN, fontSize));

         int charWidth = g.getFontMetrics().charWidth('A');
         if (code.contentCode()) {
             // Draw the lines of the text
             g.setColor(Color.WHITE);
             for (String line : code.getText().lines().toList()) {
                 g.drawString(line, 20, charWidth);
                 charWidth += 20;
             }
         }

         // Draw the cursor
         if (cursorOn) {
             // Get the width of the current line
             int lineWidth = 0;
             try {
                 if (code.contentCode()) {
                     lineWidth = g.getFontMetrics().stringWidth(code.getCurrentLine()) -
                             g.getFontMetrics().stringWidth(code.getCurrentLine().substring(code.getCurrentIndex()));
                 }
             } catch (IndexOutOfBoundsException e) {
                 // Do nothing
                 e.printStackTrace();
             }

             g.setColor(Color.WHITE);
             int x = 20 + lineWidth, y = (charWidth - 20) - code.getCurrentIndex();
             g.drawLine(x, y - fontSize - 10 , x, y + fontSize - 10);
         }

         // Draw status bar
         drawStatusBar(g);
     }

     private void drawStatusBar(Graphics g) {
        Font font = new Font("Courier New", Font.PLAIN, 17);
        g.setFont(font);
        // Draw the line separator
        g.setColor(Color.WHITE);
        g.drawLine(0, height - 25, width, height - 25);

        // Draw the status bar
        g.setColor(Color.WHITE);
        g.drawString("Line " + code.getCurrentLineNum() + " of " + code.getTotalNumOfLines(), 20, height - 10);
     }

    public void moveCursorToLeft() {
        code.decrementCurrentIndex();
        repaint();
    }

    public void moveCursorToRight() {
        code.incrementCurrentIndex();
        repaint();
    }

    public void moveCursorToUp() {
        code.decrementCurrentLineNum();
        repaint();
    }

    public void moveCursorToDown() {
        code.incrementCurrentLineNum();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Reverse the cursor status
        cursorOn = !cursorOn;

        // Repaint the panel
        super.repaint();
    }


    // Getters and setters
    public DocumentManger getCode() {
        return code;
    }

    /* *** Scrollable interface methods *** */
    public LineSeparator getLineSeparator() {
        return lineSeparator;
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return null;
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 0;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}
