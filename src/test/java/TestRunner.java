import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.annotations.Test;
import steps.CommonSteps;
import steps.LoginSteps;
import steps.VKSteps;

/**
 * Created by Boss on 30.04.2017.
 */
public class TestRunner extends BaseTest {


    @Test
    public void FriendSearch(){
        CommonSteps.openVK();
        LoginSteps.loginIntoVK("login", "password");

        VKSteps.friendsSearch("Мазур");
        VKSteps.validationOfFriendsSearch("Мазур");

        CommonSteps.checkForSoftAssertFailures();
    }
}
