package elements;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement {
    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement getElement() {
        return Browser.setUpDriver().findElement(locator);
    }

    public void click() {
        getElement().click();
    }

    public void inputText(String text) {
        getElement().sendKeys(text);
    }

    public void pressButton(Keys keys) {
        getElement().sendKeys(keys);
    }

    public String getAttribute(String attribute) {
        return getElement().getAttribute(attribute);
    }

    public boolean IsDisplayed() {
        return getElement().isEnabled();
    }

    public String getText() {
        return getElement().getText();
    }

    public Actions getActions() {
        return new Actions(Browser.setUpDriver());
    }

    public List<WebElement> getElements() {
        return Browser.setUpDriver().findElements(locator);
    }
}
