package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement loginPanel;


    public void addUserName(String name) {

        sendKeysToElement(userName, name);
        CustomListeners.test.log(Status.PASS, "Verify text" + name);
    }
    public void addPassword(String pw) {

        sendKeysToElement(password, pw);
        CustomListeners.test.log(Status.PASS, "Verify text" + pw);
    }
    public void clickLogin() {

        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Verify text" );
    }

    public void loginToApplication(String expectedMessage, String name, String pw) {
        String Message = getTextFromElement(loginPanel);
        verifyText(expectedMessage, Message, "Element not displayed");
        sendKeysToElement(userName, name);
        sendKeysToElement(password, pw);
        clickOnElement(loginButton);
    }


}
