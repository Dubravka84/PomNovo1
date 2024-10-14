package Base;

import Pages.HomepagePage;
import Pages.PracticePage;
import Pages.ProfilePage;
import Pages.TestLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public HomepagePage homepagePage;
    public PracticePage practicePage;
    public TestLoginPage testLoginPage;
    public ProfilePage profilePage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        excelReader = new ExcelReader("C:\\Users\\Korisnik\\Desktop\\TestData.xlsx");

        homepagePage = new HomepagePage(driver);
        practicePage = new PracticePage(driver);
        testLoginPage = new TestLoginPage(driver);
        profilePage = new ProfilePage(driver);
    }
}
