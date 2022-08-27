package Pages.Components;

import Pages.BasePage;
import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MenuComponent extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElementFacade openSideMenuButton;

    @FindBy(className = "shopping_cart_link")
    private WebElementFacade cartButton;

    @Getter
    @FindBy(className = "shopping_cart_badge")
    private WebElementFacade cartBadge;

    public void clickOpenSideMenuButton(){
        this.openSideMenuButton.click();
    }

    public void clickCartButton() {
        this.cartButton.click();
    }

}
