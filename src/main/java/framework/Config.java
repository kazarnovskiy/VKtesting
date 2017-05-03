package framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Gennady on 03/04/17.
 */
public class Config {

    public static final String BROWSER_NAME;
    public static final String ENVIRONMENT_NAME;
    public static final String DEFAULT_PAGE;

    public static final String DRIVER_PATH_CHROME;
    public static final int MAX_RETRIES;

    static {
        Properties properties = new Properties();
        String propsPath = "./profiles/"
                + System.getProperty("environment.name")
                + ".properties";
        String configPath = "./config.properties";

        try (InputStream profileStream = Config.class.getClassLoader()
                .getResourceAsStream(propsPath);
             InputStream configStream = Config.class.getClassLoader()
                     .getResourceAsStream(configPath)
        ) {
            properties.load(profileStream);
            properties.load(configStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        BROWSER_NAME = System.getProperty("browser.name", "chrome").toUpperCase();
        ENVIRONMENT_NAME = properties.getProperty("env.name");
        DEFAULT_PAGE = properties.getProperty("default.page");
        MAX_RETRIES = Integer.parseInt(properties.getProperty("max.retries.number"));

        if(Platform.getCurrent() == Platform.SIERRA)
            DRIVER_PATH_CHROME = properties.getProperty("driver.path.mac");
        else
            DRIVER_PATH_CHROME = properties.getProperty("driver.path.win_CH");

        System.out.println("---------------------------------------");
        System.out.println("Working on: " + BROWSER_NAME);
        System.out.println("Working with: " + ENVIRONMENT_NAME);
        System.out.println("Working at: " + DEFAULT_PAGE);
        System.out.println("---------------------------------------");
    }
//    public void setUp() throws Exception {
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "../../../apps/ApiDemos/bin");
//        File app = new File(appDir, "ApiDemos-debug.apk");

//    }
}
