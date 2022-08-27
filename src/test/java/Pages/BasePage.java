package Pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class BasePage extends PageObject {

    public boolean at(WebElementFacade element){
        return element.isVisible();
    }

}
