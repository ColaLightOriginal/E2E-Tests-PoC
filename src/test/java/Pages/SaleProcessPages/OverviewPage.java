package Pages.SaleProcessPages;

import Pages.BasePage;
import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class OverviewPage extends BasePage {

    @Getter
    @FindBy(id = "finish")
    private WebElementFacade finishButton;
}
