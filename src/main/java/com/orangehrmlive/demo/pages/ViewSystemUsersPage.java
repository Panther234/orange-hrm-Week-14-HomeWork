package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemUsersPage extends Utility {

    public ViewSystemUsersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    WebElement userName;

    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRole;

    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement userStatus;

    @FindBy(xpath = "//input[@id='searchBtn']")
    WebElement searchButton;

    @FindBy(xpath = "//a[normalize-space()='Ananya015']")
    WebElement userList;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    WebElement checkBox;

    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement deleteButton;

    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    WebElement deletePopUp;

    //@FindBy(css = "div[id='successDataModal'] div[class='modal-body']")
    @FindBy(xpath = "//div[contains(text(),'Successfully Deleted')]")
    WebElement deleteMessageDialog;

    @FindBy(xpath = "//td[normalize-space()='No Records Found']")
    WebElement noRecordsFound;

    public void sendUserName(String name) {

        sendKeysToElement(userName, name);
        CustomListeners.test.log(Status.PASS, "Send User Name" + name);
    }

    public void selectUserRole(String role) {

        selectByVisibleTextFromDropDown(userRole, role);
        CustomListeners.test.log(Status.PASS, "Select UserRole" + role);
    }

    public void selectUserStatus(String status) {

        selectByVisibleTextFromDropDown(userStatus, status);
        CustomListeners.test.log(Status.PASS, "Select UserStatus" + status);
    }

    public void selectSearchButton() {

        clickOnElement(searchButton);
        CustomListeners.test.log(Status.PASS, "Select Search Button");
    }

    public void verifyUserList(String expectedMessage) {

        verifyText(expectedMessage, userList, "User not in list");
        CustomListeners.test.log(Status.PASS, "Verify User list" + expectedMessage);
    }

    public void clickCheckBox() {

        clickOnElement(checkBox);
        CustomListeners.test.log(Status.PASS, "Select Check box");
    }

    public void clickDeleteButton() {

        clickOnElement(deleteButton);
        CustomListeners.test.log(Status.PASS, "Click Delete Button");
    }

    public void clickDeletePopUp() {

        clickOnElement(deletePopUp);
        CustomListeners.test.log(Status.PASS, "Click Delete Popup");
    }

    public void verifyUserDeletedMessage(String expectedMessage) throws InterruptedException {
        Thread.sleep(1000);
        verifyThatTextIsDisplayed(deleteMessageDialog, expectedMessage);
    }

    public void verifyNoRecordsFound(String expectedMessage) {

        String message = getTextFromElement(noRecordsFound);
        verifyText(expectedMessage, message, "Error: Record found");
        CustomListeners.test.log(Status.PASS, "Verify No record message" + expectedMessage);
    }
}
