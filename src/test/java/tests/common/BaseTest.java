package tests.common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public ChromeDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/test/resources/driverfiles/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
