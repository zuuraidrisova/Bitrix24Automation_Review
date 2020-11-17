package com.bitrix24.step_definitions;

import com.bitrix24.pages.ActiveStreamPage;
import io.cucumber.java.en.When;

import java.util.Map;

public class ActiveStream_stepDefinitions {

    ActiveStreamPage streamPage = new ActiveStreamPage();

    @When("user clicks on Send Message button")
    public void user_clicks_on_send_message_button() {

        streamPage.clickOnSendMessageInput();
    }

    @When("user uploads following file:")
    public void user_uploads_following_file(Map<String, String> dataTable) {

        streamPage.uploadFile(dataTable.get("File path"));
    }


    @When("user clicks on Send button")
    public void user_clicks_on_send_button() {

        streamPage.clickOnSendButton();
    }





}
