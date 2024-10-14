package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestWithExcel extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://practicetestautomation.com/");
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
    }

    @Test
    public void userCanLogin() {
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1, 1);

        testLoginPage.inputUsername(validUsername);
        testLoginPage.inputPassword(validPassword);
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogoutButton().isDisplayed());
    }

    @Test
    public void userCannotLoginWithInvalidUsername() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUsername = excelReader.getStringData("Sheet1", i, 2);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);
            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            testLoginPage.inputUsername(invalidUsername);
            testLoginPage.inputPassword(validPassword);
            Thread.sleep(3000);
            testLoginPage.clickOnSubmitButton();
            Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        }
    }
    @Test
    public void userCannotLoginWithInvalidPassword() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String validUsername = excelReader.getStringData("Sheet1", 1, 0);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);
            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            testLoginPage.inputUsername(validUsername);
            testLoginPage.inputPassword(invalidPassword);
            Thread.sleep(5000);
            testLoginPage.clickOnSubmitButton();
            Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        }
    }
    @Test
    public void userCannotLoginWithInvalidUsernameAndPassword() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            String invalidUsername = excelReader.getStringData("Sheet1", i, 2);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);
            homepagePage.clickOnPracticeButton();
            practicePage.clickOnTestLoginPageButton();
            testLoginPage.inputUsername(invalidUsername);
            testLoginPage.inputPassword(invalidPassword);
            Thread.sleep(5000);
            testLoginPage.clickOnSubmitButton();
            Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
        }
    }
}