package StepDefinitions;

import Steps.MenuSteps;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MenuStepDefinition {

    @Steps
    private MenuSteps menuSteps;

    @When("I click the cart button")
    public void clickCartButton(){
        this.menuSteps.clickCartButton();
    }
}
