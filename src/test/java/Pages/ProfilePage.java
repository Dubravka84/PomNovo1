package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    WebDriver driver;
    WebElement logoutButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.linkText("Log out"));
    }
    public void clickOnLogoutButton(){
        getLogoutButton().click();
    }
}
