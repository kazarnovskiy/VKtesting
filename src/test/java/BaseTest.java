import framework.GlobalsManager;
import framework.OurLogger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

/**
 * Created by Boss on 30.04.2017.
 */
public class BaseTest {

//    protected final OurLogger logger = new OurLogger(this.getClass());

    @AfterMethod
    public void afterMethod() {
        GlobalsManager.kill();
    }
}
