package Steps;

import Pages.LoginPage;
import Records.UserRecord;
import net.thucydides.core.annotations.Step;

public class LoginSteps {

    private LoginPage loginPage;

    @Step
    public void openPage(){
        this.loginPage.open();
    }

    @Step
    public void login(String userName){
        UserRecord user = new UserRecord(userName, null, null);
        this.loginPage.login(user.username(), user.password());
    }
}
