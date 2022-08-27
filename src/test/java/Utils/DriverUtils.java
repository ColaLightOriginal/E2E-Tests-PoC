package Utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

public class DriverUtils extends Serenity {

    public static void prepareDriver() {
        WebDriver webDriver = Serenity.getDriver();
        webDriver.manage().deleteAllCookies();
    }

    public static void tidyUp(){
        WebDriver webDriver = Serenity.getDriver();
        webDriver.quit();
    }
}
