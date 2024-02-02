package pages_chelyabinsk_site;

import elements.Button;
import elements.Field;
import elements.Popup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.WaitUtils;

import java.util.List;


public class TariffSelectionChelyabinskCityPage extends BasePage {
    private final static String ATTRIBUTE_VALUE = "value";
    private final Popup inputMobilePhonePopUp = new Popup(By.xpath("//div[@class='app920']"));
    private final Button closePopBpButton = new Button(By.xpath("//div[@datatest='close_popup1_from_quiz_input_tel']"));
    private final Button connectButton = new Button(By.xpath("(//div[@datatest='providers_form_inspect_connect_tariff_button'])[1]"));
    private final Field inputPhoneNumber = new Field(By.xpath("//input[@datatest='popup_tariff_order_input_tel']"));
    private final Button leaveRequestButton = new Button(By.xpath("//div[contains(@data-test,'input_connect_button')]"));
    private final Field enteredAddressField = new Field(By.xpath("//div[@id=\"root\"]//child::div//h1"));
    private final Popup thanksPopUp = new Popup(By.xpath("//form"));
    private final Button thanksButton = new Button(By.xpath("//div[@data-test='give_feedback']"));

    public TariffSelectionChelyabinskCityPage() {
        super(By.xpath("//h1"));
    }

    public boolean pageIsDisplayed() {
        WaitUtils.waitForElements(condition -> this.isDisplayed());
        return this.isDisplayed();
    }

    public void clickClosePopupOfferHelpButton() {
        WaitUtils.waitForElements(condition -> inputMobilePhonePopUp.IsDisplayed());
        closePopBpButton.click();
    }

    public boolean getAddressFromField(String address) {
        return enteredAddressField.getText().contains(address);
    }

    public boolean popUpOfferHelp() {
        WaitUtils.waitForElements(condition -> inputMobilePhonePopUp.IsDisplayed());
        return inputMobilePhonePopUp.IsDisplayed();
    }

    public void clickConnectButton() {
        connectButton.click();
    }

    public void clickOnFiledAndInputPoneNumber(String phoneNumber) {
        inputPhoneNumber.click();
        inputPhoneNumber.inputText(phoneNumber);
        WaitUtils.waitForElements(condition -> inputPhoneNumber.getText().contains(phoneNumber));
    }

    public boolean getPhoneNumber(String pressHold) {
        return inputPhoneNumber.getAttribute(pressHold).contains(ATTRIBUTE_VALUE);
    }

    public boolean popUpLeaveRequest() {
        WaitUtils.waitForElements(condition -> inputMobilePhonePopUp.IsDisplayed());
        return inputPhoneNumber.IsDisplayed();
    }

    public void clickLeaveRequestButton() {
        leaveRequestButton.click();
    }

    public boolean thanksPopUpIsDisplayed() {
        WaitUtils.waitForElements(condition -> thanksPopUp.IsDisplayed());
        List<WebElement> popUpElements = thanksPopUp.getElements();
        if (popUpElements.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void clickThanksButton() {
        WaitUtils.waitForElements(condition -> thanksPopUp.IsDisplayed());
        thanksButton.click();
    }
}
