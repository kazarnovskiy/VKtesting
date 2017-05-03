package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.constants.AbstractPage;


import static org.testng.AssertJUnit.assertTrue;
import static pages.constants.LoginConstants.*;
import static pages.constants.VKMainConstants.LNK_MESSAGES_XPATH;

/**
 * Created by Boss on 30.04.2017.
 */
public class VkLogin extends AbstractPage {

    @FindBy(xpath = TXTBX_LOGIN_XPATH)
    private WebElement txtbxLogin;

    @FindBy(xpath = TXTBX_PASSWORD_XPATH)
    private WebElement txtbxPassword;


    public VkLogin(WebDriver driver) {
        super(driver);
        waitForPageLoaded();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("Base Y page was not loaded",
                isPageLoaded());
    }

    public void login(String login, String password){
        txtbxLogin.sendKeys(login);
        txtbxPassword.sendKeys(password);
        txtbxPassword.submit();
    }

}
