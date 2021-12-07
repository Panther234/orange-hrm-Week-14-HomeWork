package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class UsersTest extends TestBase {
    HomePage homePage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    AdminPage adminPage;
    AddUserPage addUserPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        addUserPage = new AddUserPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        loginPage.loginToApplication("LOGIN Panel", "Admin", "admin123");
        dashboardPage.clickAdminTab();
        adminPage.verifyUserVerifyText("System Users");
        adminPage.clickAddButton();
        addUserPage.verifyAddUserText("Add User");
        addUserPage.selectUserRole("Admin");
        addUserPage.sendEmployeeName("Ananya Dash");
        addUserPage.sendUserName("Ananya015");
        addUserPage.selectUserStatus("Disabled");
        addUserPage.sendPassword("Abc@1234");
        addUserPage.sendConfirmPassword("Abc@1234");
        addUserPage.clickSaveButton();
        addUserPage.verifyUserSavedMessage("Successfully Saved");
    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        loginPage.loginToApplication("LOGIN Panel", "Admin", "admin123");
        dashboardPage.clickAdminTab();
        adminPage.verifyUserVerifyText("System Users");
        viewSystemUsersPage.sendUserName("Ananya015");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectUserStatus("Disabled");
        viewSystemUsersPage.selectSearchButton();
        viewSystemUsersPage.verifyUserList("Ananya015");

    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        searchTheUserCreatedAndVerifyIt();
        viewSystemUsersPage.clickCheckBox();
        viewSystemUsersPage.clickDeleteButton();
        viewSystemUsersPage.clickDeletePopUp();
        viewSystemUsersPage.verifyUserDeletedMessage("Successfully Deleted");

    }

    @Test(groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        loginPage.loginToApplication("LOGIN Panel", "Admin", "admin123");
        dashboardPage.clickAdminTab();
        adminPage.verifyUserVerifyText("System Users");
        viewSystemUsersPage.sendUserName("Ananya015");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectUserStatus("Disabled");
        viewSystemUsersPage.selectSearchButton();
        viewSystemUsersPage.verifyNoRecordsFound("No Records Found");
    }
}
