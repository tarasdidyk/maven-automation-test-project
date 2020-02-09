package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.common.BaseTest;

public class DriverHelper {

    private final SearchContext context;
    private WebDriverWait wait;
    public static final int TIMEOUT_LONG = 30;

    public DriverHelper(SearchContext context, int timeoutSec) {
        this.context = context;
        this.wait = new WebDriverWait(getDriver(), timeoutSec);
    }

    public DriverHelper(int timeoutSec) {
        this(getDriver(), timeoutSec);
    }

    public WebElement waitToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitAndClickWebElement(WebElement element) {
        waitToBeClickable(element).click();
        return element;
    }

    public static WebDriver getDriver(){
        return BaseTest.getDriver();
    }
}
