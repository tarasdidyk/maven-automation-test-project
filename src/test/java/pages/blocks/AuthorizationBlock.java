package pages.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

//@FindBy(xpath = "//div[contains(@class, 'Jea')]")
public class AuthorizationBlock extends BaseBlock {

    @FindBy(xpath = "//div[contains(text(),'Зареєструватися')]")
    WebElement registrationButton;

    @Step
    public void clickRegistrationButton() {
       h.waitAndClickWebElement(registrationButton);
    }
}
