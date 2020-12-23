package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControllerImpl implements Controller {
    private final List<String> stringHistory;
    private String toPrint;

    public ControllerImpl() {
        stringHistory = new ArrayList<>();
    }

    public final void setNextString(final String s) {
        this.toPrint = Objects.requireNonNull(s);
    }

    /** 
     * @return the next string to print
     */
    public String getNextString() {
        return this.toPrint;
    }

    /**
     * @return a list of strings' history
     */
    public List<String> getHistory() {
        return new ArrayList<>(this.stringHistory);
    }

    public final void printString() {
        if (Objects.isNull(this.getNextString())) {
            throw new IllegalArgumentException();
        }
        this.stringHistory.add(this.toPrint);
        System.out.println(this.getNextString());
    }

}
