package pages.constants;

import framework.OurLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Boss on 30.04.2017.
 */
public abstract class AbstractPage extends LoadableComponent<AbstractPage> {

    WebDriver driver;
    protected final OurLogger ourLogger;
    private final int DEFAULT_TIMEOUT = 30;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        ourLogger = new OurLogger(this.getClass());
        this.driver = driver;
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT, 100);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public WebDriver driver() {
        return this.driver;
    }

    public boolean isDriverActive() {
        return this.driver() != null && !this.driver().toString().contains("null");
    }

    String winHandleBefore;
    public String rememberOldTab(){
        winHandleBefore = driver.getWindowHandle();
//        ourLogger.info("stored handle: " + winHandleBefore);
        return winHandleBefore;
    }

    public void switchToNewTab(){
        rememberOldTab();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
//            ourLogger.info("switched to: " + driver.getWindowHandle());
        }
    }

    public void switchToOldTab(){
//        ourLogger.info("closed: " + driver.getWindowHandle());
        driver.close();
//        ourLogger.info("switching back to: " + winHandleBefore);
        driver.switchTo().window(winHandleBefore);
    }


    protected void waitUntilDisplayed(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitUntilVisibilityOfElement(WebElement locator){
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected void waitForPageLoaded(){
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return isAjaxComplete() && isPageLoaded();
            }
        });
    }

    protected boolean isAjaxComplete() {
        final JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (Boolean) executor.executeScript("return $.active == 0");
    }

    protected Boolean isPageLoaded() {
        final JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript("return document.readyState").equals("complete");
    }

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }
}
