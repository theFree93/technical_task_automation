package pages_chelyabinsk_site;

import elements.Button;
import elements.Field;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.WaitUtils;

public class SelectRegionPageBaseSite extends BasePage {
    private final Button chelyabinskCityButton = new Button(By.xpath("//div/a[@datatest='main_region_choose' and @href='/chelyabinsk']"));
    private final Field inputFirstThreeLettersOfTheCityNameField = new Field(By.xpath("//div[@id=\"root\"]//div//child::input"));

    public SelectRegionPageBaseSite() {
        super(By.xpath("//div[@class='row']"));
    }

    public boolean selectCityPageBaseSiteIsLoaded() {
        WaitUtils.waitForElements(condition -> this.isDisplayed());
        return this.isDisplayed();
    }

    public void clickAndInputFirstThreeLettersOfCityNameField(String firstThreeLettersOfCityName) {
        WaitUtils.waitForElements(condition -> inputFirstThreeLettersOfTheCityNameField.IsDisplayed());
        inputFirstThreeLettersOfTheCityNameField.getActions().
                moveToElement(inputFirstThreeLettersOfTheCityNameField.getElement()).click().build().perform();
        inputFirstThreeLettersOfTheCityNameField.inputText(firstThreeLettersOfCityName);
        WaitUtils.waitForElements(condition -> inputFirstThreeLettersOfTheCityNameField.getText().equals(firstThreeLettersOfCityName));
    }

    public boolean chelyabinskCityIsExist() {
        return chelyabinskCityButton.IsDisplayed();
    }

    public void clickOnChelyabinskCityButton() {
        WaitUtils.waitForElements(condition -> chelyabinskCityButton.IsDisplayed());
        chelyabinskCityButton.click();
    }
}
