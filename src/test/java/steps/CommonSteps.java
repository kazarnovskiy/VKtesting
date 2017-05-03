package steps;

import framework.Config;
import framework.GlobalsManager;
import framework.OurLogger;
import org.testng.annotations.DataProvider;
import pages.VkLogin;
import pages.VkMain;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.VKSteps.jPage;

/**
 * Created by Boss on 30.04.2017.
 */
public class CommonSteps {

    public static final OurLogger logger = new OurLogger(CommonSteps.class);


    @Step("Opening m.vk.com")
    public static void openVK() {
        logger.info("Opening VK.com");
        GlobalsManager.getDriver().get(Config.DEFAULT_PAGE);
    }


    public static void checkForSoftAssertFailures(){
        if (GlobalsManager.hasSoftFailures())
            throw new AssertionError(GlobalsManager.getErrorSummary());
    }
}
