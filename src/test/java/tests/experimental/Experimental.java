package tests.experimental;

import org.testng.annotations.Test;
import tests.common.BaseTest;

public class Experimental extends BaseTest {

    @Test
    public void test() {
       getDriver().get("http://google.com");
    }
}
