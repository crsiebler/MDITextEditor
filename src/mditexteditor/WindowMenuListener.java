// Assignment 2, MDI Text Editor
// Name: Cory Siebler
// StudentID: 1000832292
// Lecture Topic: 5 - GUI Components
// Description: 
package mditexteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;

/**
 *
 * @author csiebler
 */
class WindowMenuListener implements ActionListener {
    
    // Declare the Text Window to control
    private final TextWindow textWindow;
    
    // Declare the Tabbed Pane to control
    private final JTabbedPane tabbedPane;

    /**
     * Constructor
     * 
     * @param textWindow Menu Item for the Window this action relates to
     * @param tabbedPane Tabbed Pane for the Files
     */
    public WindowMenuListener(TextWindow textWindow, JTabbedPane tabbedPane) {
        this.textWindow = textWindow;
        this.tabbedPane = tabbedPane;
    }

    /**
     * Change the selected text editor when the window menu item is chosen.
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Grab the Index for the Text Editor and change the Tabs
        tabbedPane.setSelectedIndex(textWindow.getIndex());
    }
    
}
