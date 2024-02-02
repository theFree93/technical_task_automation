package pages_chelyabinsk_site;

import elements.Button;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.WaitUtils;

public class MainPageBaseSite extends BasePage {
    private final Button chooseCityButton = new Button(By.xpath("//a[@datatest='choose_region_button']"));

    public MainPageBaseSite() {
        super(By.xpath("//div[@id=\"HeaderMenu\"]"));
    }

    public boolean pageIsDisplayed() {
        WaitUtils.waitForElements(condition -> this.isDisplayed());
        return this.isDisplayed();
    }

    public void clickChooseCity() {
        WaitUtils.waitForElements(condition -> chooseCityButton.IsDisplayed());
        chooseCityButton.getActions().moveToElement(chooseCityButton.getElement()).click().build().perform();
    }
}
