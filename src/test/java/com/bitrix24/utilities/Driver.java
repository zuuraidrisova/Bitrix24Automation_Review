package com.bitrix24.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static final Logger logger = Logger.getLogger(Driver.class);

    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){

        String browser = ConfigurationReader.getProperty("browser");

        //if driver does not exist
        if(driver == null){

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser type!");
            }
        }

        logger.info("Browser: "+browser);

        return driver;
    }


    public static void closeDriver(){

        if(driver != null){

            driver.close();

            driver = null;
        }
    }



}
