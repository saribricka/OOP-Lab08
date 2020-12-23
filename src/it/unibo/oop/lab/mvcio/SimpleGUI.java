package it.unibo.oop.lab.mvcio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();
    private final Controller myController;
    private final JPanel contentPanel = new JPanel();

    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) It has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) The graphical interface consists of a JTextArea with a button "Save" right
     * below (see "ex02.png" for the expected result). SUGGESTION: Use a JPanel with
     * BorderLayout
     * 
     * 4) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 5) The program asks the controller to save the file if the button "Save" gets
     * pressed.
     * 
     * Use "ex02.png" (in the res directory) to verify the expected aspect.
     */

    /**
     * builds a new {@link SimpleGUI}.
     */
    /**
     * 
     * @param myController
     */
    public SimpleGUI(final Controller myController) {
        this.myController = myController;
        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.frame.setSize(sw / 2, sh / 2);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        this.frame.setLocationByPlatform(true);
        /*
         * SetDefaultCloseOperation
         */
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Graphical interface
         */
        this.contentPanel.setLayout(new BorderLayout());    //se inizializzo qui il JPanel, non devo usare this
        final JTextArea textArea = new JTextArea("Scrivi qui..");
        final JButton save = new JButton("SAVE");
        this.contentPanel.add(textArea, BorderLayout.CENTER);
        this.contentPanel.add(save, BorderLayout.SOUTH);

        this.frame.getContentPane().add(contentPanel, BorderLayout.CENTER);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    SimpleGUI.this.myController.stringFile(textArea.getText());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(SimpleGUI.this.frame, e1, "FILE ERROR:", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
                System.out.println("Visualizzo file: " + textArea.getText());
            }
        });

//        DocumentListener myListener = new DocumentListener();
//        textArea.getDocument().addDocumentListener(myListener);

        this.frame.setVisible(true);
    }

    public JPanel getPane() {
        return this.contentPanel;
    }

    public static void main(final String[] args) {
        new SimpleGUI(new Controller());
    }
}

