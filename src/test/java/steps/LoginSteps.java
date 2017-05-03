package steps;

import framework.GlobalsManager;
import framework.OurLogger;
import pages.VkLogin;
import ru.yandex.qatools.allure.annotations.Step;


/**
 * Created by Boss on 01.05.2017.
 */
public class LoginSteps {

    public static final OurLogger logger = new OurLogger(VKSteps.class);
    public static ThreadLocal<VkLogin> jPage = new ThreadLocal<>();

    protected static VkLogin page = page();


    private static VkLogin page() {
        if (jPage.get() == null || !jPage.get().isDriverActive())
            jPage.set(new VkLogin(GlobalsManager.getDriver()));
        return jPage.get();
    }

    @Step("Login into m.vk.com")
    public static void loginIntoVK(String login, String pass){
        logger.info("Login into VK.com");
        page.login(login, pass);
    }
}
