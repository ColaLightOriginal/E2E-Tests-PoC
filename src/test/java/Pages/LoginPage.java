package Pages;

import lombok.Data;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@Data
@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElementFacade usernameInputField;
    @FindBy(id = "password")
    private WebElementFacade passwordInputField;
    @FindBy(id= "login-button")
    private WebElementFacade loginButton;

    public void login(String username, String password){
        this.usernameInputField.sendKeys(username);
        this.passwordInputField.sendKeys(password);
        this.loginButton.click();
    }

}
