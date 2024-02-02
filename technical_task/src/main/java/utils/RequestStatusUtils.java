package utils;

import browser.Browser;
import org.openqa.selenium.JavascriptExecutor;

import java.util.logging.Logger;

public class RequestStatusUtils {
    private static final Logger LOGGER = Logger.getLogger(PropertiesUtils.class.getName());

    public static long getStatus(String url, String endPoint, String script) {
        LOGGER.info("retrieving the status of the request code");
        Browser.setUpDriver().get(url.concat(endPoint));
        JavascriptExecutor js = (JavascriptExecutor) Browser.setUpDriver();
        long result = (long) js.executeScript(script);
        return result;
    }
}
