package pages_piter_site;

import elements.Button;
import elements.DropDownMenu;
import elements.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.BasePage;
import utils.WaitUtils;

public class MainPiterSitePage extends BasePage {
    private final static String ATTRIBUTE_VALUE = "value";
    private final Field streetField = new Field(By.xpath("(//input[contains(@datatest, 'street')])[1]"));
    private final Field homeField = new Field(By.xpath("(//input[contains(@datatest, 'home')])[2]"));
    private final DropDownMenu tyeOfConnectionDropDownMenu = new DropDownMenu(By.xpath("(//div[contains(@class, 'app190')]//child::li)[1]"));
    private final Field connectionList = new Field(By.xpath("//*[@id=\"forSelectField\"]//child::div[contains(@class, 190)]"));
    private final Button showTariffsButton = new Button(By.xpath("//div[@class='justify-content-center row']//child::div[contains(@data-test, 'home_button')]"));
    private final Button closeTariffsButton = new Button(By.xpath("//div[@class='app117']//div[contains(@class, 'app179')]//child::div//input"));

    public MainPiterSitePage() {
        super(By.xpath("//div[@datatest='main_hero_banner']"));
    }

    public void waitForPageIsLoad() {
        WaitUtils.waitForElements(condition -> this.isDisplayed());
    }

    public void clickOnTheFieldAndInputStreet(String street) {
        streetField.click();
        streetField.inputText(street);
        WaitUtils.waitForElements(condition -> homeField.getAttribute(ATTRIBUTE_VALUE).contains(street));
        streetField.pressButton(Keys.ENTER);
    }

    public void clickOnTheFieldAndInputNumberOfHome(String homeNumber) {
        homeField.inputText(homeNumber);
        WaitUtils.waitForElements(condition -> homeField.getAttribute(ATTRIBUTE_VALUE).contains(homeNumber));
    }

    public void chooseTypeConnection() {
        closeTariffsButton.click();
        WaitUtils.waitForElements(condition -> connectionList.IsDisplayed());
        tyeOfConnectionDropDownMenu.getActions().moveToElement(getElement()).perform();
    }

    public void clickOnTheButtonShowTariffs() {
        WaitUtils.waitForElements(condition -> showTariffsButton.IsDisplayed());
        showTariffsButton.click();
    }
}
