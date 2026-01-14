package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.DriverFactory;
@Listeners(utils.ExtentTestListener.class)
public class BaseTest {

    protected WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
