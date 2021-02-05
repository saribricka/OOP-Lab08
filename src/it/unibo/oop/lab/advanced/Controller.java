package it.unibo.oop.lab.advanced;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Controller {

    void readSetting() throws FileNotFoundException, IOException;
    
    int getMax();
    
    int getMin();
    
    int getAttemps();
}
