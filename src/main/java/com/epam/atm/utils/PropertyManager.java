package com.epam.atm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Iryna_Alesiyuk on 3/23/2018.
 */
public class PropertyManager {
    private Properties properties;
    private FileInputStream file;

    public String propFile(String propItem)  {
        properties = new Properties();
        try {
            file = new FileInputStream("C:\\frame.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propItem);
    }

}
