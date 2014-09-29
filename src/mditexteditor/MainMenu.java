// Assignment 2, MDI Text Editor
// Name: Cory Siebler
// StudentID: 1000832292
// Lecture Topic: 5 - GUI Components
// Description: Holds the Menu Items for the MDI Text Editor in a Menu Bar.
//              Each Menu Item has a corresponding logic path in the action
//              listener. Also, the window menu must be accessible externally
//              from this class so it has getters to do such.
package mditexteditor;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menu Bar for the Text Editor. There are three menus (File, Format, Window).
 *
 * @author csiebler
 */
public class MainMenu extends JMenuBar {

    // Declare the Window Menu to hold the Text Areas
    private final JMenu windowMenu;
    
    /**
     * Constructor. Creates the JMenus to put into the JMenuBar.
     * 
     * @param actionListener
     */
    public MainMenu(ActionListener actionListener) {
        super();
        
        // Declare the Menus to store the Items
        windowMenu = new JMenu("Window");
        JMenu fileMenu = new JMenu("File");
        JMenu formatMenu = new JMenu("Format");
        
        // Declare the Submenu to select the Font, Color, and Size
        JMenu fontMenu = new JMenu("Font");
        JMenu sizeMenu = new JMenu("Size");
        JMenu colorMenu = new JMenu("Color");
        
        // Declare the File Menu Items
        fileMenu.add(makeMenuItem("New", actionListener));
        fileMenu.add(makeMenuItem("Close", actionListener));
        fileMenu.add(makeMenuItem("Exit", actionListener));
        
        // Declare the Font Menu Items
        fontMenu.add(makeMenuItem("Bold", actionListener));
        fontMenu.add(makeMenuItem("Italic", actionListener));
        fontMenu.add(makeMenuItem("Regular", actionListener));
        
        // Declare the Size Menu Items
        sizeMenu.add(makeMenuItem("10", actionListener));
        sizeMenu.add(makeMenuItem("12", actionListener));
        sizeMenu.add(makeMenuItem("14", actionListener));
        
        // Declare the Color Menu Items
        colorMenu.add(makeMenuItem("Blue", actionListener));
        colorMenu.add(makeMenuItem("Red", actionListener));
        colorMenu.add(makeMenuItem("Black", actionListener));
        
        // Add the Format Sub-Menus to the Main
        formatMenu.add(fontMenu);
        formatMenu.addSeparator();
        formatMenu.add(sizeMenu);
        formatMenu.addSeparator();
        formatMenu.add(colorMenu);
        
        // Add the Main Menus to the Bar
        add(fileMenu);
        add(formatMenu);
        add(windowMenu);
    }
    
    /**
     * Create a new Menu Item dynamically. 
     * 
     * @param label
     * @param actionListener
     * @return actionListener 
     */
    private JMenuItem makeMenuItem(String label, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(label);
        
        menuItem.setActionCommand(label);
        menuItem.addActionListener(actionListener);
        
        return menuItem;
    }

    /**
     * @return Get the Window Menu
     */
    public JMenu getWindowMenu() {
        return windowMenu;
    }
    
}
