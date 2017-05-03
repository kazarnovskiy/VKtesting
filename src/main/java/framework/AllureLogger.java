package framework;

/**
 * Created by Gennady on 24/04/17.
 */

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static framework.GlobalsManager.getDriver;

/**
 * Separate class for Allure attachments.
 */
public class AllureLogger {

    @Attachment("{0}")
    public static String logMessage(String message) {
        return "";
    }

    @Attachment
    public static String createLogAttachment(String message) {
        return message;
    }

    @Attachment("{0}")
    public static String createLogAttachment(String caption, String message) {
        return message;
    }

    @Attachment(value = "Sample plain text attachment", type = "text/plain")
    public static byte[] createFileAttachment(String contents) throws IOException {
        Path file = Files.createTempFile("__temp", ".txt");
        file.toFile().deleteOnExit();
        Files.write(file, contents.getBytes());
        return Files.readAllBytes(file);
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
