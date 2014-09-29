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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;

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
    
    // Declare the Tabbed Pane to hold the Text Editors
    private final JTabbedPane tabbedPane;
    
    // Declare the list of Text Editors & The Menu Bar
    private final MainMenu mainMenu;
    private final List<TextEditor> textEditors;
    private final List<TextWindow> textWindows;
    private TextEditor currentEditor;

    /**
     * Constructor. Grabs the OS Resolution Size and creates the Menu Bar.
     */
    public MDITextEditor() {
        super();
        setTitle("MDI Text Editor");
        
        // Set the size of the frame to the current screen resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        
        // Set the Text Editor count to 0
        editorCount = 0;
        
        // Initialize the Text Windows & Text Editor List
        textWindows = new ArrayList<>();
        textEditors = new ArrayList<>();
        
        // Initialize the Menu Bar
        mainMenu = new MainMenu(this);
        
        // Initialize the Tabbed Pane
        tabbedPane = new JTabbedPane();
        
        // Add a listener to the Tabbed Pane
        tabbedPane.addChangeListener((ChangeEvent e) -> {
            // Grab the selected index
            int index = tabbedPane.getSelectedIndex();
            
            // Make sure a Tab is selected
            if (index < 0) {
                // No tab selected so set the current editor to null
                currentEditor = null;
            } else {
                // Set the current editor to the proper file
                currentEditor = textEditors.get(tabbedPane.getSelectedIndex());
            }
        });
        
        // Set the Menu Bar for the Frame
        setJMenuBar(mainMenu);
        
        // Add the Tabbed Pane to the Frame
        add(tabbedPane);
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
                // Create a new file
                newFile();
                break;
            case "Close":
                // Close the current file
                closeFile();
                break;
            case "Exit":
                // Exit the program
                exitProgram();
                break;
            case "Bold":
                // Change the font to Bold
                fontBold();
                break;
            case "Italic":
                // Change the font to Italic
                fontItalic();
                break;
            case "Regular":
                // Change the font to Regular
                fontRegular();
                break;
            case "10":
                // Change the font size to 10
                size10();
                break;
            case "12":
                // Change the font size to 12
                size12();
                break;
            case "14":
                // Change the font size to 14
                size14();
                break;
            case "Blue":
                // Change the font color to Blue
                colorBlue();
                break;
            case "Red":
                // Change the font color to Red
                colorRed();
                break;
            case "Black":
                // Change the font color to Black
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
        // Grab the index for the Text Editor
        int index = textEditors.size();
        
        // Check if the limit on windows has been met
        if (index < MAX_WINDOWS) {
            // Increment the Editor Count
            editorCount++;
            
            // Initialize a new Text Editor & Text Window
            TextEditor textEditor = new TextEditor(index);
            TextWindow textWindow = new TextWindow(editorCount, index);
            
            // Add a Listener for the Text Window
            textWindow.addActionListener(
                    new WindowMenuListener(textWindow, tabbedPane)
            );
            
            // Add the Text Editor to the Array of Windows
            textWindows.add(textWindow);
            textEditors.add(textEditor);
            
            // Add the Text Window into the Window Menu
            mainMenu.getWindowMenu().add(textWindow);
            
            // Change the current editor to the new file
            currentEditor = textEditor;
            
            // Load the Default font for the new Text Editor
            currentEditor.loadFont();
            
            // Add the new Text Editor to the Tabbed Pane
            tabbedPane.add("File " + editorCount, currentEditor);
            tabbedPane.setSelectedIndex(index);
        }
    }

    /**
     * Closes the currently open file.
     */
    private void closeFile() {
        // Grab the Index of the current Text Editor & the Size of the Editors
        int index = currentEditor.getIndex();
        int size = textEditors.size();
        
        // Remove the current Text Editor from the Window Menu and the Array
        textWindows.remove(index);
        textEditors.remove(index);
        
        // Remove the current Text Editor from the Tabbed Pane
        tabbedPane.remove(index);
        
        // Grab the previous Text Editor if available
        if (size > 1) {
            // Calculate the previous index
            int previous = size - 2;
            
            // Set the Current Text Editor to the previous file
            currentEditor = textEditors.get(previous);
            tabbedPane.setSelectedIndex(previous);
        } else {
            // No Editor is available
            currentEditor = null;
        }
        
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

    /**
     * For each Text Editor, updated the Menu Item and index in the ArrayLists.
     */
    private void updateWindowMenu() {
        // Remove all Text Windows from the List
        mainMenu.getWindowMenu().removeAll();
        
        // Loop through all the Text Editors and Add them to the Menu Bar
        for (int i = 0; i < textWindows.size(); ++i) {
            // Update the Index for the Text Editors
            textWindows.get(i).setIndex(i);
            textEditors.get(i).setIndex(i);
            
            // Add the Text Windows to the Window Menu
            mainMenu.getWindowMenu().add(textWindows.get(i));
        }
    }
    
}
