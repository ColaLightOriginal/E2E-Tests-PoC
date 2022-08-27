package Pages.SaleProcessPages;

import Pages.BasePage;
import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@Getter
public class YourCartPage extends BasePage {

    private final String cartItemClassSelector = "cart_item";
    private final String cartNameClassSelector = "inventory_item_name";
    private final String cartDescriptionClassSelector = "inventory_item_desc";
    private final String cartPriceClassSelector = "inventory_item_price";
    private final String carttAddToCardButtonClassSelector = "button[id^='remove-']";

    @FindBy(className = "cart_list")
    private WebElementFacade yourCartProductsList;

    @FindBy(id = "checkout")
    private WebElementFacade checkoutButton;

}
