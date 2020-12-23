package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;
import it.unibo.oop.lab.mvcio.SimpleGUI;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JPanel contentPanel;
    private final Controller myController;
    private final JPanel selectPathPane = new JPanel();

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */
public SimpleGUIWithFileChooser(final Controller myController, final SimpleGUI gui, JPanel contentPanel) {
    final SimpleGUI simpleGUI = Objects.requireNonNull(gui);
    this.contentPanel = contentPanel;
    this.myController = myController;
    this.selectPathPane.setLayout(new BorderLayout());
    final JTextField filePath = new JTextField(this.myController.getCurrentFilePath());
    filePath.setEditable(false);
    final JButton browse = new JButton("BROWSE...");
    this.selectPathPane.add(filePath, BorderLayout.WEST);
    this.selectPathPane.add(browse, BorderLayout.LINE_END);

    this.contentPanel.add(selectPathPane, BorderLayout.NORTH);
    this.contentPanel.revalidate();
}



}
