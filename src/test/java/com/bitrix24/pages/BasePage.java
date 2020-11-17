package com.bitrix24.pages;

import com.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public abstract class BasePage { //this is an abstract class so no one can instantiate it

    private final static Logger logger = Logger.getLogger(BasePage.class);
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    //we just need below constructor to be called in sub classes to initialize web elements
    public BasePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Method used for navigation. Module name will be specified in feature file:
     *   And user navigates to "Activity Stream"
     *               ||
     *  |@Given("user navigates to {string}")
     *  public void user_navigates_to(String module){
     *      loginPage.navigateTo(module);
     *  }
     *              ||
     *
     * @param moduleName like Tasks, Mail, Calendar, Activity Stream
     */


    public void navigateTo(String moduleName){
        //if moduleName = Activity Stream, then xpath looks like this:
        // //span[contains(text(),'Activity Stream') and @class='menu-item-link-text']

        //  and this xpath represents Activity Stream link on the page
        String xpath = "//span[contains(text(),'"+moduleName+"') and @class='menu-item-link-text']";

        //wait for presence of element and click on it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();

        logger.info("Navigating to: "+moduleName);
    }


}
