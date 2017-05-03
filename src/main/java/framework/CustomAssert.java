package framework;

import org.testng.Assert;

/**
 * Created by Boss on 12.04.2017.
 */
public class CustomAssert {

    private static OurLogger logger= new OurLogger(CustomAssert.class);



    public static void assertTrue(String assertMsg, boolean subject,
                                  String errorMsg, boolean isSoft) {
        logger.info(assertMsg);
        try {
            Assert.assertTrue(subject, errorMsg);
            logger.info("Test passed");
        } catch (AssertionError err) {
            String caughtMsg = err.getMessage();
            if (isSoft) {
                logger.warning("Error caught: " + caughtMsg);
                GlobalsManager.appendError(caughtMsg);
            } else throw err;
        }
    }

    public static void assertSoftFalse(String assertMsg, boolean subject,
                                  String errorMsg, boolean isSoft) {
        logger.info(assertMsg);
        try {
            Assert.assertFalse(subject, errorMsg);
            logger.info("Test passed");
        } catch (AssertionError err) {
            String caughtMsg = err.getMessage();
            if (isSoft) {
                logger.warning("Error caught: " + caughtMsg);
                GlobalsManager.appendError(caughtMsg);
            } else throw err;
        }
    }

    public static void assertEquals(String assertMsg,
                                    Object subjectOne, Object subjectTwo,
                                    String errorMsg, boolean isSoft) {
        logger.info(assertMsg);
        try {
            Assert.assertEquals(subjectOne, subjectTwo, errorMsg);
            logger.info("Test passed");
        } catch (AssertionError err) {
            String caughtMsg = err.getMessage();
            if (isSoft) {
                logger.warning("Error caught: " + caughtMsg);
                GlobalsManager.appendError(caughtMsg);
            } else throw err;
        }
    }

    public static void assertNotEquals(String assertMsg,
                                    Object subjectOne, Object subjectTwo,
                                    String errorMsg, boolean isSoft) {
        logger.info(assertMsg);
        try {
            Assert.assertNotEquals(subjectOne, subjectTwo, errorMsg);
            logger.info("passed");
        } catch (AssertionError err) {
            String caughtMsg = err.getMessage();
            if (isSoft) {
                logger.warning("Error caught: " + caughtMsg);
                GlobalsManager.appendError(caughtMsg);
            } else throw err;
        }
    }
}
