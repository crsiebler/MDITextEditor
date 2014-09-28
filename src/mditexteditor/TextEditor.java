// Assignment 2, MDI Text Editor
// Name: Cory Siebler
// StudentID: 1000832292
// Lecture Topic: 5 - GUI Components
// Description: 
package mditexteditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Text Area to edit the files.
 *
 * @author csiebler
 */
public class TextEditor extends JPanel {

    // Declare the Text Area to edit the file
    private final TextArea textArea;
    
    private int index;
    
    // Initialize the Font Variables
    private int fontSize = 12;
    private int fontType = Font.PLAIN;
    private Color fontColor = Color.BLACK;
    
    /**
     * Constructor. Create the Scroll Pane and the Text Area to edit the files.
     * 
     * @param index Index in the Array of Text Editors
     */
    public TextEditor(int index) {
        // Initialize a Text Area to edit text
        textArea = new TextArea();
        
        // Set the Index of the Text Editor to the parameter given
        this.index = index;

        // Initialize a Scroll Pane to hold the Text Area
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Set up the Scroll Pane for Scrolling
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        // Allow the user to edit the Text Area
        textArea.setEditable(true);
        
        // Add the Scroll Pane
        add(scrollPane);
        
        // Make the JPanel 
        setVisible(true);
    }
    
    /**
     * Change the Font from outside the class. Modify the font type, size, and
     * foreground color.
     */
    public void loadFont() {
        textArea.setFont(new Font("Serif", fontType, fontSize));
        textArea.setForeground(fontColor);
    }

    /**
     * @return Index of the Text Editor in the Array
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param fontSize Size of the Font
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * @param fontType Type of the Font (e.g. Bold, Italic, Plain)
     */
    public void setFontType(int fontType) {
        this.fontType = fontType;
    }

    /**
     * @param fontColor Color of the Font
     */
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

}
