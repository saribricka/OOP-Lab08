
package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControllerImpl implements Controller {
    private List<String> historyList;
    private String toPrint;
    public ControllerImpl() {
        historyList = new ArrayList<>();
    }
    @Override
    public final void setNext(final String strIn) {
        Objects.requireNonNull(strIn);
        this.toPrint = strIn;
        //this.historyList.add(toPrint);    add only when you print it
    }
    @Override
    public final String getNext() {
        return this.toPrint;
    }
    @Override
    public final List<String> getHistory() {
        return new ArrayList<>(this.historyList);
    }
    @Override
    public final void printCurrent(final String current) {
        this.toPrint = current;
        this.historyList.add(this.toPrint);
        System.out.println(this.getNext());
    }
}
