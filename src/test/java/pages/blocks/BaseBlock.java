package pages.blocks;

import org.openqa.selenium.SearchContext;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.DriverHelper;

import java.sql.Driver;

public abstract class BaseBlock extends HtmlElement {

    public DriverHelper h;

    public BaseBlock() {
        h = new DriverHelper(this, DriverHelper.TIMEOUT_LONG);
    }
}
