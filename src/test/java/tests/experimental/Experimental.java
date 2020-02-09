package tests.experimental;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.common.BaseTest;

public class Experimental extends BaseTest {

    @Step("Step")
    public void step() {
        getDriver().get("http://google.com");
    }

    @Test
    public void test() {
        step();
       getDriver().get("http://google.com");
    }
}
