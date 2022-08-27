package Steps;

import Enums.PagesEnum;
import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.SaleProcessPages.YourCartPage;
import net.thucydides.core.annotations.Step;

public class PagesSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;

    @Step
    public boolean atPage(PagesEnum pageEnum){
        switch (pageEnum){
            case LOGIN_PAGE -> {
                return this.loginPage.at(this.loginPage.getUsernameInputField());
            }
            case PRODUCTS_PAGE -> {
                return this.productsPage.at(this.productsPage.getProductsListElement());
            }
            case YOU_CART_PAGE -> {
                return this.yourCartPage.at(this.yourCartPage.getYourCartProductsList());
            }
        }
        return false;
    }
}
