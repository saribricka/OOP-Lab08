package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.commons.io.FileUtils;

/**
 * 
 */
public class Controller {

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

    private String currentFilePath = System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt";
    private File currentFile = new File(this.currentFilePath);

    public final File getCurrentFile() {
        return this.currentFile;
    }

    public final void setCurrentFile(final File newFile) {
        Objects.requireNonNull(newFile);
        this.currentFile = newFile;
        this.currentFilePath = newFile.getAbsolutePath();   //What's the diff between getPath and getAbsolutePath
    }

    public final String getCurrentFilePath() {
        return this.currentFile.getPath();
    }

    public final void setCurrentFilePath(final String newFilePath) {
        Objects.requireNonNull(newFilePath);
        final File newFile = new File(newFilePath);
        if (!newFile.isFile()) {
            throw new IllegalArgumentException(newFile.getAbsolutePath() + "cannot be used as a file");
        }
        this.currentFile = newFile;
        this.currentFilePath = newFilePath;
    }

    /**
     * 
     * @param textFile
     * @throws IOException
     */
    public final void stringFile(final String textFile) throws IOException {
            FileUtils.write(this.currentFile, textFile, StandardCharsets.UTF_8);
    }
} 
