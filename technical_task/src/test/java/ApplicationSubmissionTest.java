import browser.Browser;
import enums.PropertyVariable;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsReader;
import utils.PropertiesUtils;
import utils.RequestStatusUtils;

public class ApplicationSubmissionTest extends BaseTest {


    @Test(testName = "Test1", enabled = false)
    public void testSubmitApplicationWithSearch() {
        LOGGER.info("Go to the site input street, home number, choose type of connection and click button show tariffs");
        Browser.setUpDriver().manage().window().maximize();
        mainPage.waitForPageIsLoad();
        mainPage.clickOnTheFieldAndInputStreet(STREET_TEST_LINE);
        mainPage.clickOnTheFieldAndInputNumberOfHome(HOME_NUMBER_ONE);
        mainPage.chooseTypeConnection();
        mainPage.clickOnTheButtonShowTariffs();

        LOGGER.info("Close appear pop up");
        tariffSelectionPage.closePopUp();

        LOGGER.info("Click connection button, input mobile phone, click leave the request " +
                "button and click thanks to close pop up and check status request and repeat it five times.");
        for (int i = 0; i < AMOUNT_COMPARING_STATUS_CODE; i++) {
            tariffSelectionPage.waitLoadingPage();
            tariffSelectionPage.clickConnectButtons();
            tariffSelectionPage.inputMobileNumber(PropertiesUtils.loadProperties(PATH_TO_DATA_PROPERTIES, PropertyVariable.PHONE_NUMBER));
            tariffSelectionPage.clickLeaveRequestButton();
            tariffSelectionPage.clickThanks();

            Assert.assertEquals(RequestStatusUtils.getStatus(PropertiesUtils.loadProperties(PATH_TO_DATA_PROPERTIES, PropertyVariable.URL),
                    END_POINT_FOR_REQUEST, JsReader.readFile(PATH_TO_SCRIPT)
            ), 200, "Request is not equals 200");
        }
    }
}
