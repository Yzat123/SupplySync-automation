package tests;

import Pages.ProjectLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseUI;
import utils.Driver;

public class ProjectLoginTest extends BaseUI {
    WebDriver driver = Driver.getDriver();
    ProjectLoginPage loginPage = new ProjectLoginPage();

    @Test
    public void successfulLoginTest() {
        loginPage.login("admin@codewise.com", "codewise123");

        explicitWait(20).until(ExpectedConditions.urlContains("dashboard"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test
    public void invalidEmail() {
        loginPage.login("admin@codewi14.com", "codewise123");
        waitUntilVisible(10, loginPage.invalidCredentialsMessage);
        Assertions.assertTrue(loginPage.invalidCredentialsMessage.isDisplayed());


    }

    @Test
    public void invalidPassword() {
        loginPage.login("admin@codewi14.com", "codewise45");
        waitUntilVisible(10, loginPage.invalidCredentialsMessage);
        Assertions.assertTrue(loginPage.invalidCredentialsMessage.isDisplayed());


    }
    @Test
    public void emptyPasswordField() {
        loginPage.login("admin@codewi14.com", "");
        waitUntilVisible(10, loginPage.invalidCredentialsMessage);
        Assertions.assertTrue(loginPage.invalidCredentialsMessage.isDisplayed());


    }
    @Test
    public void emptyEmailField() {
        loginPage.login("", "codewise123");
        waitUntilVisible(10, loginPage.invalidCredentialsMessage);
        Assertions.assertTrue(loginPage.invalidCredentialsMessage.isDisplayed());


    }
    @Test
    public void bothEmptyField() {
        loginPage.login("", "");
        waitUntilVisible(10, loginPage.invalidCredentialsMessage);
        Assertions.assertTrue(loginPage.invalidCredentialsMessage.isDisplayed());
  }
    @Test
    public void adminIsAbleToLogout() {
        loginPage.login("admin@codewise.com", "codewise123");
        explicitWait(20).until(ExpectedConditions.urlContains("dashboard"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        loginPage.logout();
        Assertions.assertTrue(driver.getCurrentUrl().contains("/login"));
    }



}


