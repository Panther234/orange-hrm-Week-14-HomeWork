package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='welcome']")
    WebElement verifyWelcome;

    @FindBy(xpath = "//img[@alt='OrangeHRM']")
    WebElement logoPanel;

    @FindBy(xpath = "//b[normalize-space()='Admin']")
    WebElement adminMenu;

    @FindBy(xpath = "//b[normalize-space()='PIM']")
    WebElement pIMMenu;

    @FindBy(xpath = "//b[normalize-space()='Leave']")
    WebElement leaveMenu;

    @FindBy(xpath = "//b[normalize-space()='Dashboard']")
    WebElement dashBordMenu;


    public void verifyWelcomeText(String text){
        verifyThatTextIsDisplayed(verifyWelcome, text);
    }

    public void verifyLogoDisplayed() {
        Boolean logoPresent = logoPanel.isDisplayed();
        Assert.assertTrue(logoPresent);
        if (logoPresent) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }
    }

}
