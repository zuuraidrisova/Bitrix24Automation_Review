package com.bitrix24.pages;

import com.bitrix24.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage { //this is an abstract class so no one can instantiate it

    //we just need below constructor to be called in sub classes to initialize web elements
    public BasePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


}
