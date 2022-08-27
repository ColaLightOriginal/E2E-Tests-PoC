package Pages;

import Records.ProductRecord;
import lombok.Data;
import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductsPage extends BasePage{

    private final String productItemClassSelector = "inventory_item";
    private final String productNameClassSelector = "inventory_item_name";
    private final String productDescriptionClassSelector = "inventory_item_desc";
    private final String productPriceClassSelector = "inventory_item_price";
    private final String productAddToCardButtonClassSelector = "button[id^='add-to-cart-']";

    @FindBy(className = "inventory_list")
    private WebElementFacade productsListElement;

}
