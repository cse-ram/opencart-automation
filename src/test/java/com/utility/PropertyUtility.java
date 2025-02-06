package com.utility;

import com.constants.Env;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

    public static String getProperty(Env env, String property) {
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader(String.format("configs/%s.properties", env));
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(property.toUpperCase());
    }
}
