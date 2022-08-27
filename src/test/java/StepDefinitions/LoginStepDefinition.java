package StepDefinitions;

import Steps.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefinition {

    @Steps
    private LoginSteps loginSteps;

    @Given("I am at login page")
    public void openLoginPage(){
        this.loginSteps.openPage();
    }

    @When("I login as {string}")
    public void loginAsUser(String userName) {
        this.loginSteps.login(userName);
    }



}
