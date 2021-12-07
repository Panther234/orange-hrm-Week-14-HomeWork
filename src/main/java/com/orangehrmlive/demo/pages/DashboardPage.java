package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Utility {

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[normalize-space()='Admin']")
    WebElement adminTab;

    @FindBy(xpath = "//a[@id='welcome']")
    WebElement userProfileLogo;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutClick;

    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement loginPanel;

    public void clickAdminTab() {
        clickOnElement(adminTab);
        CustomListeners.test.log(Status.PASS, "Click Admin tab" );
    }

    public void clickUserProfileLogo() {
        clickOnElement(userProfileLogo);
        CustomListeners.test.log(Status.PASS, "Click User profile" );
    }

    public void clickLogoutClick() throws InterruptedException {
        clickOnElement(logoutClick);
        CustomListeners.test.log(Status.PASS, "Click Logout " );
    }

    public void verifyLoginPanel(String expectedMessage) {
        String message = getTextFromElement(loginPanel);
        verifyText(expectedMessage, message, "Message not displayed");
        CustomListeners.test.log(Status.PASS, "Verify LoginPanel" + expectedMessage);
    }
}
