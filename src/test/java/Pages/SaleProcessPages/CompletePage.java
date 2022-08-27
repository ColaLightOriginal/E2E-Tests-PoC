package Pages.SaleProcessPages;

import Pages.BasePage;
import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CompletePage extends BasePage {

    @Getter
    @FindBy(className = "pony_express")
    private WebElementFacade ponyExpressLogo;

}
