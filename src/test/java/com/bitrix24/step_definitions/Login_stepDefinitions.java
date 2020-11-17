package com.bitrix24.step_definitions;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Login_stepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on login page")
    public void user_is_on_login_page() {

       // Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        //this step is already coming from Hooks class Before annotation
    }


    @Given("user logs in as {string}")
    public void user_logs_in_as(String role) {

        loginPage.login(role);

    }


    @And("user navigates to {string}")
    public void userNavigatesTo(String moduleName) {

        loginPage.navigateTo(moduleName);
    }
















}
