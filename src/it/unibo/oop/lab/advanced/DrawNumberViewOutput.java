package it.unibo.oop.lab.advanced;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class DrawNumberViewOutput implements DrawNumberView {
    
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String PATH = System.getProperty("usr.dir")
            + SEPARATOR
            + "res"
            + SEPARATOR
            + "log.txt";
    private PrintStream ps;

    @Override
    public void setObserver(final DrawNumberViewObserver observer) throws FileNotFoundException {
        this.ps = new PrintStream(new FileOutputStream(new File(PATH)));
    }

    @Override
    public void start() {
        this.ps.println("The game has started!");
    }

    @Override
    public void numberIncorrect() {
        this.ps.println("The number is incorrect");
    }

    @Override
    public void result(final DrawResult res) {
        this.ps.println(res.getDescription());
    }

    @Override
    public void limitsReached() {
        this.ps.println("The limit has been reached... You Lost!");
    }

    @Override
    public void displayError(final String message) {
        this.ps.println("ERROR: " + message);
    }

}
