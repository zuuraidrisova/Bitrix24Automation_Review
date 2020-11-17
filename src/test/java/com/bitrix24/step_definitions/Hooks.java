package com.bitrix24.step_definitions;

import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private static final Logger logger = Logger.getLogger(Hooks.class);

    //logger is for organized system out messages
    @Before
    public void setUp(){

        logger.info("Starting automation :::  ");

        logger.info("Browser Type: "+ ConfigurationReader.getProperty("browser"));

        logger.info("URL: "+ConfigurationReader.getProperty("url"));

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){

        logger.info("Taking a screenshot for failed scenarios");

        if(scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot)(Driver.getDriver())).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

        logger.info("Ending automation ::: ");

    }


}
