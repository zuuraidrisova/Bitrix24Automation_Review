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

        String username = ConfigurationReader.getProperty("helpdesk_username");
        String password = ConfigurationReader.getProperty("password");

        emailInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);

       // System.out.println("Login with "+username +" username and "+password+" password");
       //the same system out we can do thru logger now to have more organized message
        logger.info("Login with "+username +" username and "+password+" password");

    }

    /**
     * this method takes parameter
     * @param role as hr, marketing, helpdesk
     * and logins according to credentials
     */

    public void login(String role){

        role = role.toLowerCase();
        // helpdesk_username :  helpdesk is coming from parameter,
        // the rest _username we add so our ConfigurationReader
        // utility method can recognize the value
        String username = ConfigurationReader.getProperty(role+"_username");
        String password = ConfigurationReader.getProperty("password");


        emailInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);

        logger.info("Logins as : "+role);

    }



}
