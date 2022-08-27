package Steps;

import Pages.Components.MenuComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class MenuSteps {
    MenuComponent menuComponent;

    @Step
    public void clickCartButton(){
        this.menuComponent.clickCartButton();
    }

    @Step
    public int getCartBadgeNumber(){
        String tmp = this.menuComponent.getCartBadge().getText();
        return Integer.parseInt(this.menuComponent.getCartBadge().getText());
    }
}
