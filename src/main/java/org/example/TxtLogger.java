package org.example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TxtLogger {
    public static Logger logger = Logger.getLogger("Log");

    public static void init(){
        FileHandler fh;

        try{
            fh = new FileHandler("src/main/Log.txt");

            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
