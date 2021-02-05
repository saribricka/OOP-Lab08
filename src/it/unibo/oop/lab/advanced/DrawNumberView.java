package it.unibo.oop.lab.advanced;

import java.io.FileNotFoundException;

/**
 *
 */
public interface DrawNumberView {

    /**
     * @param observer the controller to attach
     * @throws FileNotFoundException 
     */
    void setObserver(DrawNumberViewObserver observer) throws FileNotFoundException;

    /**
     * This method is called before the UI is used. It should finalize its status (if needed).
     */
    void start();

    /**
     * Tells the user that the inserted number is not correct.
     */
    void numberIncorrect();

    /**
     * @param res the result of the last draw
     */
    void result(DrawResult res);

    /**
     * Tells the user that the match is lost.
     */
    void limitsReached();
    
    /**
     * Tells the user which is the error.
     * @param message is the error message
     */
    void displayError(String message);

}
