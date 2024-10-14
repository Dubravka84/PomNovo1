package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.PracticePage;
import Pages.ProfilePage;
import Pages.TestLoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://practicetestautomation.com/");

        homepagePage = new HomepagePage(driver);
        practicePage = new PracticePage(driver);
        testLoginPage = new TestLoginPage(driver);
        profilePage = new ProfilePage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void userCanLogin(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.inputUsername("student");
        testLoginPage.inputPassword("Password123");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLogoutButton().isDisplayed());
    }
    @Test
    public void userCannotLoginWithInvalidUsername(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.inputUsername("non student");
        testLoginPage.inputPassword("Password123");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
    }
    @Test
    public void userCannotLoginWithInvalidPassword(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.inputUsername("student");
        testLoginPage.inputPassword("Password1234");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
    }
    @Test
    public void userCannotLoginWithEmptyUsernameField(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.inputUsername("");
        testLoginPage.inputPassword("Password123");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
    }
    @Test
    public void userCannotLoginWithEmptyPasswordField(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.inputUsername("student");
        testLoginPage.inputPassword("");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
    }
    @Test
    public void userCannotLoginWithEmptyFields(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.inputUsername("");
        testLoginPage.inputPassword("");
        testLoginPage.clickOnSubmitButton();
        Assert.assertTrue(testLoginPage.getSubmitButton().isDisplayed());
    }
}
