package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gennady on 03/04/17.
 */
public class DriverFactory {

    public static WebDriver getDriver() {
        WebDriver driver;
        switch (Config.BROWSER_NAME) {
            case "IE":
                throw new IllegalArgumentException("R U NUTS?!");
            case "FIREFOX":
//            case "MOBILE_CHROME":
//                DesiredCapabilities capabilities =  DesiredCapabilities.android();
//                capabilities.setCapability("device","Android");
//                capabilities.setCapability("app", app.getAbsolutePath());
//                capabilities.setCapability("app-package", "com.example.android.apis");
//                capabilities.setCapability("app-activity", ".ApiDemos");
//                driver = new SwipeableWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            case "CHROME":
            default:
                System.setProperty("webdriver.chrome.driver", Config.DRIVER_PATH_CHROME);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        }
        return driver;
    }
}
