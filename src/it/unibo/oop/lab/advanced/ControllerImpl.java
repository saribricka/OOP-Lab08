package it.unibo.oop.lab.advanced;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ControllerImpl implements Controller {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String CONFIG_PATH = System.getProperty("usr.dir")
            + SEPARATOR
            + "res"
            + SEPARATOR
            + "config.yml";
    private int minDefault;
    private int maxDefault;
    private int attempsDefault;

    public ControllerImpl() {
        this.minDefault = 0;
        this.maxDefault = 100;
        this.attempsDefault = 10;
    }

    @Override
    public void readSetting() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(CONFIG_PATH));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                StringTokenizer st = new StringTokenizer(line, ": ");
                String config = st.nextToken();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMax() {
        return this.maxDefault;
    }

    @Override
    public int getMin() {
        return this.minDefault;
    }

    @Override
    public int getAttemps() {
        return this.attempsDefault;
    }
}
