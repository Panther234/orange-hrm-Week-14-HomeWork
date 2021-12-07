package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginTest extends TestBase {
    HomePage homePage;
    DashboardPage dashboardPage;
    LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
    }

    @Test (groups = {"sanity", "regression"})
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.addUserName("Admin");
        loginPage.addPassword("admin123");
        loginPage.clickLogin();
        homePage.verifyWelcomeText("welcome");
    }

    @Test(groups = {"smoke", "regression"})
    public void VerifyThatTheLogoDisplayOnHomePage() {
        loginPage.addUserName("Admin");
        loginPage.addPassword("admin123");
        loginPage.clickLogin();
        homePage.verifyLogoDisplayed();
    }

    @Test(groups = {"regression"})
    public void VerifyUserShouldLogOutSuccessFully() throws InterruptedException {
        loginPage.addUserName("Admin");
        loginPage.addPassword("admin123");
        loginPage.clickLogin();
        dashboardPage.clickUserProfileLogo();
        dashboardPage.clickLogoutClick();
        dashboardPage.verifyLoginPanel("LOGIN Panel");

    }
}
