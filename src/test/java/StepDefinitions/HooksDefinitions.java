package StepDefinitions;

import Utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksDefinitions {
    @Before
    public void beforeTest(){
        DriverUtils.prepareDriver();
    }

    @After
    public void afterTest(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
//        this.menuSteps.logout();
        DriverUtils.tidyUp();
    }
}
