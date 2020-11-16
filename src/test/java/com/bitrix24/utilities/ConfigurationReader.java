package com.bitrix24.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {

        String path = "configuration.properties";

        try{

            properties = new Properties();

            FileInputStream file = new FileInputStream(path);

            properties.load(file);

            file.close();

        }catch (IOException e){

            System.out.println("Properties file path is not correct!");
            e.printStackTrace();

        }
    }

    public static String getProperty(String keyWord){

        return properties.getProperty(keyWord);
    }
}
