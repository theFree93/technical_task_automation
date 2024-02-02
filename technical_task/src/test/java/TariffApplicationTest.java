import browser.Browser;
import enums.PropertyVariable;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesUtils;

public class TariffApplicationTest extends BaseTest {

    @Test(testName = "Test2", enabled = false)
    public void testSubmitApplicationFromAnyTariff() {
        Browser.setUpDriver().manage().window().maximize();
        LOGGER.info("Go to the main site 101internet and click choose city");
        Assert.assertTrue(mainPageBaseSite.pageIsDisplayed(), "Page is not displayed");
        mainPageBaseSite.clickChooseCity();

        LOGGER.info("Click on filed search city and enter first three letters calling city " +
                "and also click on Chelyabinsk city button");
        Assert.assertTrue(selectRegionPageBaseSite.selectCityPageBaseSiteIsLoaded(), "Page is not displayed");
        selectRegionPageBaseSite.clickAndInputFirstThreeLettersOfCityNameField(FIRST_TREE_LETTERS_OF_CITY_NAME);
        Assert.assertTrue(selectRegionPageBaseSite.chelyabinskCityIsExist(), "Chelyabinsk city is not displayed");
        selectRegionPageBaseSite.clickOnChelyabinskCityButton();

        LOGGER.info("Go to Chelyabinsk link and enter street, home number and also choose type of connection in drop down menu" +
                "and click show tariffs button");
        Assert.assertTrue(mainChelyabinskCityPage.mainChelyabinskCitySitePageISLoaded(),
                "Page Chelyabinsk city is not displayed");
        mainChelyabinskCityPage.clickOnStreetFieldAndInputStreet(TYRKINA_STREET);
        Assert.assertTrue(mainChelyabinskCityPage.getEnteredStreetName(), "Field is not contains entered street");
        mainChelyabinskCityPage.clickOnHomeNumberFieldAndInputNumber(HOME_NUMBER_THREE);
        Assert.assertTrue(mainChelyabinskCityPage.getEnteredHomeNumber(), "Field is not contains entered home number");
        mainChelyabinskCityPage.chooseTypeConnection();
        mainChelyabinskCityPage.closeDropDownMenu();
        Assert.assertTrue(mainChelyabinskCityPage.getTypeOfConnection(), "Type of connection is not choose");
        mainChelyabinskCityPage.clickOnShowTariffsButton();

        LOGGER.info("Close pop and click connect button there already input phone number in pop up leave request after all" +
                "click leave request, click button 'thanks' to finalize request");
        Assert.assertTrue(tariffSelectionChelyabinskCityPage.popUpOfferHelp(), "Pop up offer help is not displayed");
        tariffSelectionChelyabinskCityPage.clickClosePopupOfferHelpButton();
        Assert.assertTrue(tariffSelectionChelyabinskCityPage.getAddressFromField(TYRKINA_STREET),
                "Entered address is not displayed");
        Assert.assertTrue(tariffSelectionChelyabinskCityPage.pageIsDisplayed(), "Page is not displayed");
        tariffSelectionChelyabinskCityPage.clickConnectButton();
        Assert.assertTrue(tariffSelectionChelyabinskCityPage.popUpLeaveRequest(), "Pop up leave request is not displayed");
        tariffSelectionChelyabinskCityPage.clickOnFiledAndInputPoneNumber(PropertiesUtils.loadProperties
                (PATH_TO_DATA_PROPERTIES, PropertyVariable.PHONE_NUMBER));
        Assert.assertTrue(tariffSelectionChelyabinskCityPage.getPhoneNumber(PRESS_HOLDER),
                "Press holder is not displayed");
        tariffSelectionChelyabinskCityPage.clickLeaveRequestButton();
        Assert.assertTrue(tariffSelectionChelyabinskCityPage.thanksPopUpIsDisplayed(), "Thanks pop up is not displayed");
        tariffSelectionChelyabinskCityPage.clickThanksButton();
        Assert.assertFalse(tariffSelectionChelyabinskCityPage.thanksPopUpIsDisplayed(), "Thanks pop up is displayed");
    }
}

