package framework;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Gennady on 24/04/17.
 */
public class CustomListener extends TestListenerAdapter
        implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    @Step("Test failed, see attachments")
    public void onTestFailure(ITestResult tr) {
        AllureLogger.createLogAttachment("empty attachment log phrase");
        AllureLogger.createLogAttachment("LOG", tr.getThrowable().getMessage());
        try {
            AllureLogger.createFileAttachment(tr.getThrowable().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AllureLogger.attachScreenshot("failure_" + tr.getName());
}

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(CustomListener.class);
    }

    private int currentRetries = 0;

    @Override
    public boolean retry(ITestResult result) {
        return currentRetries++ < Config.MAX_RETRIES;
    }
}
