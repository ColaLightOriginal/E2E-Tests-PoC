package StepDefinitions;

import Enums.PagesEnum;
import Steps.PagesSteps;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PagesStepDefinition {

    @Steps
    private PagesSteps pagesSteps;

    @Then("I am at {string}")
    public void atPage(String pageName) {
        Assert.assertTrue(this.pagesSteps.atPage(PagesEnum.valueOf(pageName)));
    }

}
