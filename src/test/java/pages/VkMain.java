package pages;

import framework.CustomAssert;
import framework.OurLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.constants.AbstractPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;
import static pages.constants.VKMainConstants.*;

/**
 * Created by Boss on 30.04.2017.
 */
public class VkMain extends AbstractPage {

    protected OurLogger logger = new OurLogger(this.getClass());

    @FindBy(xpath = LNK_MESSAGES_XPATH)
    private WebElement lnkDialogs;

    @FindBy(xpath = LNK_FRIENDS_XPATH)
    private WebElement lnkFriends;

    @FindBy(xpath = TXTBX_DIALOGS_SEARCH_XPATH)
    private WebElement txtbxDilogsSearch;

    @FindBy(xpath = TXTBX_FRIENDS_SEARCH_XPATH)
    private WebElement txtbxFriendsSearch;

    @FindBy(xpath = TXTBX_MESSAGE_TEXT_XPATH)
    private WebElement txtbxMessageText;


    public VkMain(WebDriver driver) {
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

    public void openDialogs(){
        logger.info("Opening Dialogs");
        lnkDialogs.click();
        waitForPageLoaded();
    }

    public void openFriendsList(){
        logger.info("Opening friends list");
        lnkFriends.click();
        waitForPageLoaded();
    }

    public void friendSearch (String friendsName){
        txtbxFriendsSearch.click();
        txtbxFriendsSearch.sendKeys(friendsName);
    }

    public void dialogSearch (String friendsName){
        txtbxDilogsSearch.click();
        txtbxDilogsSearch.sendKeys(friendsName);
    }

    public void checkThatDialogFoundCorrectly(String friendsName){
        List <WebElement> searchResults= driver().findElements(By.xpath(LNK_DIALOGS_SEARCH_RESULTS_XPATH));
        for (WebElement element : searchResults){
            boolean searchResultsAreCorrect = element.getText().contains(friendsName);
            CustomAssert.assertTrue("Validation if found dialog name is correct",
                    searchResultsAreCorrect,"Search results are incorrect", false);
        }
    }

    public void checkThatFriendsFoundCorrectly(String friendsName){
        List <WebElement> searchResults= driver().findElements(By.xpath(LBL_FRIENDS_SEARCH_RESULTS_XPATH));
        for (WebElement element : searchResults){
            boolean searchResultsAreCorrect = element.getText().contains(friendsName);
            CustomAssert.assertTrue("Validation if found dialog name is correct",
                    searchResultsAreCorrect,"Search results are incorrect", false);
        }
    }

    public void checkThatPageOwnerWillNotBeFound(String friendsName){
        List <WebElement> searchResults= driver().findElements(By.xpath(LBL_FRIENDS_SEARCH_RESULTS_XPATH));
        for (WebElement element : searchResults){
            boolean searchResultsAreCorrect = element.getText().contains(friendsName);
            CustomAssert.assertSoftFalse("Validation if found dialog name is correct",
                    searchResultsAreCorrect,"Search results are incorrect", false);
        }
    }

    public void sendMessage(String message){
        txtbxMessageText.sendKeys(message);
        txtbxMessageText.submit();
    }

    public void selectDialog(String friendName){
        txtbxDilogsSearch.sendKeys(friendName);
        WebElement searchResult = driver().findElement(By.xpath(LNK_DIALOGS_SEARCH_RESULTS_XPATH));
        searchResult.click();
    }

    public void checkThatMessageIsSent(String message){
        List <WebElement> searchResults= driver().findElements(By.xpath(LBL_MESSAGES_LIST_XPATH));
        WebElement lastMessage= searchResults.get(0);
        boolean messageIsSent = lastMessage.getText().trim().contains(message);
            CustomAssert.assertSoftFalse("Validation if found dialog name is correct",
                    messageIsSent,"Search results are incorrect", false);

    }

}
