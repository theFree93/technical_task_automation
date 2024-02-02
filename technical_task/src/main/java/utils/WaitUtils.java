package utils;

import enums.PropertyVariable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import browser.Browser;

import java.time.Duration;
import java.util.logging.Logger;

public class WaitUtils {
    private static final Logger LOGGER = Logger.getLogger(WaitUtils.class.getName());
    private final static String PATH_TO_PROPERTIES = "./src/main/resources/data.properties";

    public static void waitForElements(ExpectedCondition<Boolean> condition) {
        LOGGER.info("Installing an explicit wait");
        int amountOfWaitingInSec = Integer.parseInt(PropertiesUtils.loadProperties(PATH_TO_PROPERTIES, PropertyVariable.AMOUNT_OF_WAIT));
        try {
            new WebDriverWait(Browser.setUpDriver(), Duration.ofSeconds(amountOfWaitingInSec)).until(condition);
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
    }
}
