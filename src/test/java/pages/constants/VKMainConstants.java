package pages.constants;

/**
 * Created by Boss on 30.04.2017.
 */
public class VKMainConstants {

    public static final String LNK_MESSAGES_XPATH="//a[@href='/mail']//span[contains(text(),'Сообщения')]";
    public static final String TXTBX_DIALOGS_SEARCH_XPATH="//div[@class='basisDialogs__filter dialogs_filter ']//input[@type='text']";
    public static final String LNK_DIALOGS_SEARCH_RESULTS_XPATH="//div[@class='ii_body']";
    public static final String LNK_FRIENDS_XPATH="//a[@href='/friends']//span[contains(text(),'Друзья')]";
    public static final String TXTBX_FRIENDS_SEARCH_XPATH="//div[@class='hp_block _hide']//input[@type='text']";
    public static final String LBL_FRIENDS_SEARCH_RESULTS_XPATH="//div[@class='simple_fit_item']";
    public static final String LBL_MESSAGES_LIST_XPATH="//div[@onclick='return MessagesActions.onMessageClick(event);']";
    public static final String TXTBX_MESSAGE_TEXT_XPATH="//textarea[@name='message']";

}
