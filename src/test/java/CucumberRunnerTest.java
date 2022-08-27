import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
        features="src/test/resources/features",
        glue = "StepDefinitions")
public class CucumberRunnerTest {
}
