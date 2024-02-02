package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import browser.Browser;

public abstract class BasePage {
    private final By locator;

    protected BasePage(By locator) {
        this.locator = locator;
    }

    public WebElement getElement() {
        return Browser.setUpDriver().findElement(locator);
    }

    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }
}
