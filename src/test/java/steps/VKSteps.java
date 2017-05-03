package steps;

import framework.GlobalsManager;
import framework.OurLogger;
import pages.VkMain;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Boss on 30.04.2017.
 */
public class VKSteps {

    public static final OurLogger logger = new OurLogger(VKSteps.class);
    public static ThreadLocal<VkMain> jPage = new ThreadLocal<>();

    protected static VkMain page = page();


    private static VkMain page() {
        if (jPage.get() == null || !jPage.get().isDriverActive())
            jPage.set(new VkMain(GlobalsManager.getDriver()));
        return jPage.get();
    }


    public static void friendsSearch(String friendsName){
        page.openFriendsList();
        logger.info("Opening Friends List");
        page.friendSearch(friendsName);
        logger.info("Search for friend: " +friendsName);
    }

    @Step("")
    public static void validationOfFriendsSearch(String friendsName){
        logger.info("Validation that correct friends are found");
        page.checkThatFriendsFoundCorrectly(friendsName);
    }

    public static void dialogsSearch(String friendsName){
        logger.info("Opening Dialogs");
        page.openDialogs();
        logger.info("Search for dialog with " +friendsName);
        page.dialogSearch(friendsName);
    }

    public static void validationOfDialogsSearch(String friendsName){
        logger.info("Validation that correct dialogs are found");
        page.checkThatDialogFoundCorrectly(friendsName);
    }

    public static void validationThatAccountOwnerWillNotBeFound(String friendsName){
        logger.info("Validation that" + friendsName +"is not found");
        page.checkThatPageOwnerWillNotBeFound(friendsName);
    }

    public static void sendMessage(String friendName, String message){
        logger.info("Selecting the dialog for message");
        page.selectDialog(friendName);
        logger.info("Sending the message");
        page.sendMessage(message);
    }

    public static void validationThatMessageIsSent (String message){
        logger.info("Validation that message sent");
        page.checkThatMessageIsSent(message);
    }

}
