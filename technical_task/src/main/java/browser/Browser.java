package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    private static WebDriver driver;

    public static void navigateToOrders(String baseUrl, String endPoint) {
        driver.get(baseUrl + endPoint);
    }

    private Browser() {
    }

    public static WebDriver setUpDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void driverTearDown() {
        driver.quit();
    }
}
