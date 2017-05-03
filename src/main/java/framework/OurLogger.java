package framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;


/**
 * Created by Gennady on 10/04/17.
 */
public class OurLogger {

    private Class clazz;
    private final Logger logger;

    public OurLogger(Class clazz) {
        this.clazz = clazz;
        logger = LogManager.getLogger(clazz);
    }

    private void reporterLog(String message) {
        Reporter.log(clazz.getSimpleName() + ": " + message);
    }

    public void debug(String message) {
        logger.debug(message);
        reporterLog(message);
    }

    public void warning(String message) {
        logger.warn(message);
        reporterLog(message);
    }

    public void error(String message) {
        logger.error(message);
        reporterLog(message);
    }

    public void info(String message) {
        logger.info(message);
        reporterLog(message);
        AllureLogger.logMessage(message);
    }
}
