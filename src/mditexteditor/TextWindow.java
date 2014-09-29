// Assignment 2, MDI Text Editor
// Name: Cory Siebler
// StudentID: 1000832292
// Lecture Topic: 5 - GUI Components
// Description: 
package mditexteditor;

import javax.swing.JMenuItem;

/**
 *
 * @author csiebler
 */
class TextWindow extends JMenuItem {

    // Declare the Index to keep track of the position in the ArrayList
    private int index;
    
    /**
     * Constructor
     * 
     * @param count Number of Text Editors created
     * @param index Position in the ArrayList
     */
    public TextWindow(int count, int index) {
        super("File " + count);
        
        // Initialize the Index of the Menu Item
        this.index = index;
    }

    /**
     * @return Position in the ArrayList
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index Position in the ArrayList
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
}
