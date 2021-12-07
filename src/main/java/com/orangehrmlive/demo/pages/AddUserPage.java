package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends Utility {

    public AddUserPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@id='UserHeading']")
    WebElement addUserVerify;
    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement userRole;
    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement employeeName;
    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement userName;
    @FindBy(xpath = "//select[@id='systemUser_status']")
    WebElement userStatus;
    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    WebElement confirmPassword;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement saveButton;
    //@FindBy(css = "#frmList_ohrmListComponent > script")
    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    WebElement savedMessage;


    public void verifyAddUserText(String expectedMessage) {

        String message = getTextFromElement(addUserVerify);
        verifyText(expectedMessage, message, "Message not displayed");
        CustomListeners.test.log(Status.PASS, "Verify Add user text " + expectedMessage);
    }

    public void selectUserRole(String role) {

        selectByVisibleTextFromDropDown(userRole, role);
        CustomListeners.test.log(Status.PASS, "Select User role " + role);
    }

    public void sendEmployeeName(String name) {

        sendKeysToElement(employeeName, name);
        CustomListeners.test.log(Status.PASS, "Add Employee name" + name);
    }

    public void sendUserName(String user) {

        sendKeysToElement(userName, user);
        CustomListeners.test.log(Status.PASS, "Add User name " + user);
    }

    public void selectUserStatus(String status) {

        selectByVisibleTextFromDropDown(userStatus, status);
        CustomListeners.test.log(Status.PASS, "Select User status " + status);
    }

    public void sendPassword(String pw) {

        sendKeysToElement(password, pw);
        CustomListeners.test.log(Status.PASS, "Send Password " + pw);
    }

    public void sendConfirmPassword(String cpw) {

        sendKeysToElement(confirmPassword, cpw);
        CustomListeners.test.log(Status.PASS, "Send Confirm Password " + cpw);
    }

    public void clickSaveButton() {

        clickOnElement(saveButton);
        CustomListeners.test.log(Status.PASS, "Click save button ");
    }

    public void verifyUserSavedMessage(String expectedMessage) throws InterruptedException {
        verifyThatTextIsDisplayed(savedMessage, expectedMessage);
        CustomListeners.test.log(Status.PASS, "Verify User saved message " + expectedMessage);
    }
}

