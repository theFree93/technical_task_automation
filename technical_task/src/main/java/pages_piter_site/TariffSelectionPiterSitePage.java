package pages_piter_site;

import elements.BaseElement;
import elements.Button;
import elements.Field;
import elements.Popup;
import org.openqa.selenium.By;
import utils.WaitUtils;


public class TariffSelectionPiterSitePage extends BaseElement {
    private final Popup congratulationsPopUp = new Popup(By.xpath("//div[@datatest='close_popup1_from_quiz_input_tel']"));
    private final Button connectButtons = new Button(By.xpath("((//div[contains(@datatest, 'connect_tariff_button')]//child::div//child::a)[1])"));
    private final Popup inputMobilePhonePopUp = new Popup(By.xpath("//div[@class='app1026']"));
    private final Field mobileNumberField = new Field(By.xpath("//input[contains(@datatest,'input_tel')]"));
    private final Popup thanksPopUp = new Popup(By.xpath("//div[@data-test='give_feedback']"));
    private final Button leaveRequestButton = new Button(By.xpath("//div[@data-test='popup_tariff_order_form_input_connect_button']"));

    public TariffSelectionPiterSitePage() {
        super(By.xpath("//div[@datatest='main_hero_banner']"));
    }

    public void waitLoadingPage() {
        WaitUtils.waitForElements(condition -> this.IsDisplayed());
    }

    public void closePopUp() {
        WaitUtils.waitForElements(conditions -> congratulationsPopUp.IsDisplayed());
        congratulationsPopUp.click();
    }

    public void clickConnectButtons() {
        WaitUtils.waitForElements(condition -> connectButtons.IsDisplayed());
        connectButtons.click();
    }

    public void inputMobileNumber(String phoneNumber) {
        WaitUtils.waitForElements(condition -> inputMobilePhonePopUp.IsDisplayed());
        mobileNumberField.click();
        mobileNumberField.inputText(phoneNumber);
        WaitUtils.waitForElements(conditions -> mobileNumberField.getText().contains(phoneNumber));
    }

    public void clickLeaveRequestButton() {
        leaveRequestButton.click();
        WaitUtils.waitForElements(condition -> !thanksPopUp.IsDisplayed());

    }

    public void clickThanks() {
        WaitUtils.waitForElements(condition -> thanksPopUp.IsDisplayed());
        thanksPopUp.getActions().moveToElement(thanksPopUp.getElement()).click().build().perform();
    }
}
