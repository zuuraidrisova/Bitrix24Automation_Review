package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class ActiveStreamPage extends BasePage {

    private final static Logger logger = Logger.getLogger(BasePage.class);

    @FindBy(id="microoPostFormLHE_blogPostForm_inner")
    private WebElement sendMessageInputBox;

    @FindBy(css = "[title='Upload files']")
    private WebElement uploadFilesIcon;

    @FindBy(name ="bxu_files[]")
    private WebElement uploadFilesAndImages;

    @FindBy(id = "blog-submit-button-save")
    private WebElement sendButton;


    public void clickOnSendMessageInput(){

        wait.until(ExpectedConditions.visibilityOf(sendMessageInputBox));

        sendMessageInputBox.click();
    }

    /**
     * File path will be provided as a parameter. Should start with src.
     *
     * @param filePath like src/test/resources/testData/image.jpeg
     */

    public void uploadFile(String filePath){

        filePath = System.getProperty("user.dir")+"/"+ filePath.replace("/",File.separator);

        logger.info("File path: " + filePath);

        wait.until(ExpectedConditions.visibilityOf(uploadFilesIcon));

        uploadFilesIcon.click();

        BrowserUtils.waitFor(2);

        uploadFilesAndImages.sendKeys(filePath);
        // wait.until(ExpectedConditions.visibilityOf(uploadFilesAndImages));

        BrowserUtils.waitFor(2);

    }


    public void clickOnSendButton(){

        wait.until(ExpectedConditions.visibilityOf(sendButton)).click();

        logger.info("Clicking on the Send button");
    }

}
