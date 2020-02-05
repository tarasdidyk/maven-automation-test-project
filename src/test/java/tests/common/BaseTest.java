package tests.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private Map<String, Object> capabilities = new HashMap<>();
    private ChromeOptions options = new ChromeOptions();

    private void initDriver(ChromeOptions newOptions) {
        if (Utils.isEnvironmentRemote()) {
            URL host = null;
            try {
                host = new URL("http://192.168.0.106:4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            RemoteWebDriver driver = new RemoteWebDriver(host, newOptions);
            driver.setFileDetector(new LocalFileDetector());
            driverPool.set(driver);
        } else {
            System.setProperty("webdriver.chrome.driver",
                    new File(this.getClass().getResource("/chromedriver.exe").getFile())
                            .getPath());
            driverPool.set(new ChromeDriver(newOptions));
        }
    }

    public ChromeOptions getOptions() {
        if (!capabilities.isEmpty()) {
            capabilities.forEach((k, v) -> options.setCapability(k, v));
        }
        return options;
    }

    public void setCapabilities(HashMap<String, Object> newCapabilities) {
        capabilities.putAll(newCapabilities);
    }

    public void clearCapabilities() {
        capabilities.clear();
    }

    public static WebDriver getDriver() {
        return driverPool.get();
    }

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        for (Map.Entry entry : capabilities.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
        initDriver(getOptions());
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        if (Utils.isEnvironmentRemote()) {
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }
    }

    @AfterTest(alwaysRun = true)
    public void quit() {
        driverPool.get().quit();
    }
}
