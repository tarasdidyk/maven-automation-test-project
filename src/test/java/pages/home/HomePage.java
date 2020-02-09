package pages.home;

import io.qameta.allure.Step;
import pages.BasePage;
import pages.blocks.AuthorizationBlock;

public class HomePage extends BasePage {

    public AuthorizationBlock authorizationBlock;

    @Step
    public void clickRegistrationButton(){
        authorizationBlock.clickRegistrationButton();
    }
}
