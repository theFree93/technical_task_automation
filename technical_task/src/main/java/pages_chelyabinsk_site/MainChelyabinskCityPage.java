package pages_chelyabinsk_site;

import elements.Button;
import elements.DropDownMenu;
import elements.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.BasePage;
import utils.WaitUtils;

public class MainChelyabinskCityPage extends BasePage {
    private final static String ATTRIBUTE_VALUE = "value";
    private final Field streetField = new Field(By.xpath("(//input[@datatest='main_input_street_home_new'])[1]"));
    private final Field homeNumberField = new Field(By.xpath("(//input[@datatest='main_input_street_home_new'])[2]"));
    private final Button closeTariffsButton = new Button(By.xpath("(//span[contains(@class, 'icon-arrow-1-down')])[1]"));
    private final DropDownMenu listOfAllConnections = new DropDownMenu(By.xpath("//div[@class='app187 app190']"));
    private final DropDownMenu connectionsDropdownMenu = new DropDownMenu(By.xpath("(//div[@id=\"forSelectField\"]/div//li)[1]"));
    private final Button showTariffsButton = new Button(By.xpath("//div[@class='justify-content-center row']//div[@data-test='find_tohome_button']"));

    public MainChelyabinskCityPage() {
        super(By.xpath("//div[@class='justify-content-center row']"));
    }

    public boolean mainChelyabinskCitySitePageISLoaded() {
        WaitUtils.waitForElements(condition -> this.isDisplayed());
        return this.isDisplayed();
    }

    public void clickOnStreetFieldAndInputStreet(String street) {
        WaitUtils.waitForElements(condition -> streetField.IsDisplayed());
        streetField.getActions().moveToElement(streetField.getElement()).click().build().perform();
        streetField.inputText(street);
        WaitUtils.waitForElements(condition -> streetField.getAttribute(ATTRIBUTE_VALUE).contains(street));
        streetField.pressButton(Keys.ENTER);
    }

    public boolean getEnteredStreetName() {
        return !streetField.getAttribute(ATTRIBUTE_VALUE).isEmpty();
    }

    public void clickOnHomeNumberFieldAndInputNumber(String homeNumber) {
        WaitUtils.waitForElements(condition -> homeNumberField.IsDisplayed());
        homeNumberField.click();
        homeNumberField.inputText(homeNumber);
        WaitUtils.waitForElements(condition -> homeNumberField.getAttribute(ATTRIBUTE_VALUE).contains(homeNumber));
        homeNumberField.pressButton(Keys.ENTER);
    }

    public boolean getEnteredHomeNumber() {
        return !streetField.getAttribute(ATTRIBUTE_VALUE).isEmpty();
    }

    public void chooseTypeConnection() {
        connectionsDropdownMenu.getActions().moveToElement(connectionsDropdownMenu.getElement()).click().build().perform();
        WaitUtils.waitForElements(condition -> !listOfAllConnections.IsDisplayed());
    }

    public void closeDropDownMenu() {
        closeTariffsButton.getActions().moveToElement(getElement()).build().perform();
    }

    public boolean getTypeOfConnection() {
        return !connectionsDropdownMenu.getAttribute(ATTRIBUTE_VALUE).isEmpty();
    }

    public void clickOnShowTariffsButton() {
        showTariffsButton.click();
    }
}
