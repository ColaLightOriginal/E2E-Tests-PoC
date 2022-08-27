package Pages.SaleProcessPages;

import Pages.BasePage;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@Getter
public class CheckoutInformationPage extends BasePage {

    @Setter
    @FindBy(id = "first-name")
    private WebElementFacade firstNameInputField;

    @Setter
    @FindBy(id = "last-name")
    private WebElementFacade lastNameInputField;

    @Setter
    @FindBy(id = "postal-code")
    private WebElementFacade postalCodeInputField;

    @FindBy(id = "continue")
    private WebElementFacade continueButton;
}
