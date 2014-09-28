// Assignment 2, MDI Text Editor
// Name: Cory Siebler
// StudentID: 1000832292
// Lecture Topic: 5 - GUI Components
// Description: 
package mditexteditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

/**
 * Requirements:
 * 1) The MDI parent shall have a Format menu.
 * 2) The MDI parent shall have sub-menus to control the size, font, and color
 *    of the text in the active child window.
 * 3) Each sub-menu shall provide a minimum of three options of your choice.
 * 4) The MDI parent shall have a File menu, with menu items New (create a new
 *    child), Close (close the active child), and Exit (exit the app).
 * 5) The MDI parent shall have a Window menu to display the list of the child
 *    windows.
 *
 * @author csiebler
 */
public class MDITextEditor extends JFrame implements ActionListener {

    private static final int MAX_WINDOWS = 5; // Maximum of windows
    
    // Declare the count of Text Editors open
    private int editorCount;
    
    // Declare the list of Text Editors & The Menu Bar
    private final MainMenu mainMenu;
    private final TextEditor[] textEditors;
    private final JMenuItem[] textWindows;
    private TextEditor currentEditor;

    /**
     * Constructor. Grabs the OS Resolution Size and creates the Menu Bar.
     */
    public MDITextEditor() {
        super();
        setTitle("MDI Text Editor");
        
        // Set the size of the frame to the current screen resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height - 50);
        
        // Set the Text Editor count to 0
        editorCount = 0;
        
        // Initialize the Text Windows & Text Editor List
        textWindows = new JMenuItem[MAX_WINDOWS];
        textEditors = new TextEditor[MAX_WINDOWS];
        
        // Initialize the Menu Bar
        mainMenu = new MainMenu(this);
        
        // Set the Menu Bar for the Frame
        setJMenuBar(mainMenu);
    }
    
    /**
     * Create the MDI Text Editor.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MDITextEditor editor = new MDITextEditor();
        editor.setVisible(true);
    }

    /**
     * Gather the action performed and determine which menu item the user
     * selected.
     * 
     * @param e Contains the Action Command of the Menu Item
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New":
                newFile();
                break;
            case "Close":
                closeFile();
                break;
            case "Exit":
                exitProgram();
                break;
            case "Bold":
                fontBold();
                break;
            case "Italic":
                fontItalic();
                break;
            case "Regular":
                fontRegular();
                break;
            case "10":
                size10();
                break;
            case "12":
                size12();
                break;
            case "14":
                size14();
                break;
            case "Blue":
                colorBlue();
                break;
            case "Red":
                colorRed();
                break;
            case "Black":
                colorBlack();
                break;
            default:
                break;
        }
    }

    /**
     * Generates a new file and adds a menu item to the Window section.
     */
    private void newFile() {
        // Check if the limit on windows has been met
        if (textWindows.length < MAX_WINDOWS) {
            // Grab the Index to put the Text Editor into
            int index = editorCount % MAX_WINDOWS;

            // Initialize a new Text Editor
            TextEditor textEditor = new TextEditor(index);
            
            // Add the Text Editor to the Array of Windows
            textWindows[index] = new JMenuItem("Text " + index);
            textEditors[index] = textEditor;
        }
    }

    /**
     * Closes the currently open file.
     */
    private void closeFile() {
        // Grab the Index of the current Text Editor
        int index = currentEditor.getIndex();
        
        // Remove the current Text Editor from the Window Menu and the Array
        textWindows[index] = null;
        textEditors[index] = null;
        
        // Set the Current Text Editor to Null
        currentEditor = null;
        
        // Refresh the Windows
        updateWindowMenu();
    }

    /**
     * Alerts the system to exit the program.
     */
    private void exitProgram() {
        System.exit(0); // Exit application
    }

    /**
     * Changes the current font to bold.
     */
    private void fontBold() {
        if (currentEditor != null) {
            currentEditor.setFontType(Font.BOLD);
            currentEditor.loadFont();
        }
    }

    /**
     * Changes the current font to italic.
     */
    private void fontItalic() {
        if (currentEditor != null) {
            currentEditor.setFontType(Font.ITALIC);
            currentEditor.loadFont();
        }
    }

    /**
     * Changes the current font to regular.
     */
    private void fontRegular() {
        if (currentEditor != null) {
            currentEditor.setFontType(Font.PLAIN);
            currentEditor.loadFont();
        }
    }

    /**
     * Changes the font size to 10.
     */
    private void size10() {
        if (currentEditor != null) {
            currentEditor.setFontSize(10);
            currentEditor.loadFont();
        }
    }

    /**
     * Changes the font size to 12.
     */
    private void size12() {
        if (currentEditor != null) {
            currentEditor.setFontSize(12);
            currentEditor.loadFont();
        }
    }

    /**
     * Changes the font size to 14.
     */
    private void size14() {
        if (currentEditor != null) {
            currentEditor.setFontSize(14);
            currentEditor.loadFont();
        }
    }

    /**
     * Changes the font color to blue.
     */
    private void colorBlue() {
        if (currentEditor != null) {
            currentEditor.setFontColor(Color.BLUE);
            currentEditor.loadFont();
        }
    }

    /**
     * Changes the font color to red.
     */
    private void colorRed() {
        if (currentEditor != null) {
            currentEditor.setFontColor(Color.RED);
            currentEditor.loadFont();
        }
    }

    /**
     * Changes the font color to black.
     */
    private void colorBlack() {
        if (currentEditor != null) {
            currentEditor.setFontColor(Color.BLACK);
            currentEditor.loadFont();
        }
    }

    private void updateWindowMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
