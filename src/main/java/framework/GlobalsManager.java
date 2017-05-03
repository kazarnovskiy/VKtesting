package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Gennady on 03/04/17.
 */
public class GlobalsManager {
    static Logger logger = LogManager.getLogger(GlobalsManager.class);
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<StringBuilder> errorStack = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        if (hasDriver()) webDriver.remove();
        webDriver.set(driver);
    }

    public static WebDriver getDriver() {
        if (!hasDriver()) {
            logger.debug("creating driver");
            setDriver(DriverFactory.getDriver());
        }
        return webDriver.get();
    }

    public static boolean hasDriver() {
        return webDriver.get() != null
                && !webDriver.get().toString().contains("null");
    }

    public static void kill() {
        if (hasDriver()) {
            logger.debug("destroying driver");
            getDriver().quit();
            webDriver.remove();
        }
    }

    public static StringBuilder getErrorStack() {
        if (errorStack.get() == null) {
            StringBuilder errStack = new StringBuilder();
            errStack.append("Errors caught:\n");
            errorStack.set(errStack);
        }
        return errorStack.get();
    }

    public static boolean hasSoftFailures(){
        return getErrorSummary().length() > 15;
    }

    public static String getErrorSummary(){
        return getErrorStack().toString();
    }

    public static void appendError(String errorMsg) {
        getErrorStack().append(errorMsg).append("\n");
    }
}
