// Assignment 2, MDI Text Editor
// Name: Cory Siebler
// StudentID: 1000832292
// Lecture Topic: 5 - GUI Components
// Description: The class to hold the logic for editting the text file. Consists
//              of a TextArea inside a JPanel. Has an index field to keep track
//              of its position in the ArrayList. Also, has a public methods to
//              modify the font for the editor.
package mditexteditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * Text Area to edit the files.
 *
 * @author csiebler
 */
public class TextEditor extends JPanel {

    // Declare the Text Area to edit the file
    private final TextArea textArea;
    
    // Declare the Position of the Text Editor in the ArrayList
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
        
        // Set the size of the frame to the current screen resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.setSize(
                screenSize.getWidth() - 25,
                screenSize.getHeight() - 120
        );
        textArea.setPreferredSize(screenSize);
        
        // Set the Index of the Text Editor to the parameter given
        this.index = index;
        
        // Set the Text Area properties
        textArea.setEditable(true);
        
        // Add the Text Area to the Panel
        add(textArea);
        
    }
    
    /**
     * Change the Font from outside the class. Modify the font type, size, and
     * foreground color.
     */
    public void loadFont() {
        textArea.setFont(new Font("Arial", fontType, fontSize));
        textArea.setForeground(fontColor);
    }

    /**
     * @return Index of the Text Editor in the ArrayList
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index Index of the Text Editor in the ArrayList
     */
    public void setIndex(int index) {
        this.index = index;
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
