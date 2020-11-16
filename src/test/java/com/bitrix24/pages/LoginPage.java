package com.bitrix24.pages;

import com.bitrix24.utilities.ConfigurationReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(name = "USER_LOGIN")
    private WebElement emailInput;

    @FindBy(name = "USER_PASSWORD")
    private WebElement passwordInput;

    public void login(){

        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        emailInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);

       // System.out.println("Login with "+username +" username and "+password+" password");
       //the same system out we can do thru logger now to have more organized message
        logger.info("Login with "+username +" username and "+password+" password");

    }

}
