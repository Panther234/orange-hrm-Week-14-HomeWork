package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends Utility {

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='System Users']")
    WebElement systemUserVerify;

    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;

    public void verifyUserVerifyText(String expectedMessage) {
        String message = getTextFromElement(systemUserVerify);
        verifyText(expectedMessage, message, "Message not displayed");
        CustomListeners.test.log(Status.PASS, "Verify User text " + expectedMessage);
    }

    public void clickAddButton() {

        clickOnElement(addButton);
        CustomListeners.test.log(Status.PASS, "Click Add button " );
    }

}
