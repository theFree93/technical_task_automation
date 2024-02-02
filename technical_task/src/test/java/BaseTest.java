import browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages_chelyabinsk_site.MainChelyabinskCityPage;
import pages_chelyabinsk_site.MainPageBaseSite;
import pages_chelyabinsk_site.SelectRegionPageBaseSite;
import pages_chelyabinsk_site.TariffSelectionChelyabinskCityPage;
import pages_piter_site.MainPiterSitePage;
import pages_piter_site.TariffSelectionPiterSitePage;

import java.util.logging.Logger;

public class BaseTest {
    protected static final Logger LOGGER = Logger.getLogger(ApplicationSubmissionTest.class.getName());
    protected final TariffSelectionPiterSitePage tariffSelectionPage = new TariffSelectionPiterSitePage();
    protected final MainPiterSitePage mainPage = new MainPiterSitePage();
    protected final MainPageBaseSite mainPageBaseSite = new MainPageBaseSite();
    protected final SelectRegionPageBaseSite selectRegionPageBaseSite = new SelectRegionPageBaseSite();
    protected final static String PATH_TO_DATA_PROPERTIES = "./src/main/resources/data.properties";
    protected final static String PATH_TO_SCRIPT = "./src/main/resources/script.js";
    protected final static String END_POINT_FOR_REQUEST = "api/orders?type=site101-callback";
    protected final static int AMOUNT_COMPARING_STATUS_CODE = 5;
    protected final static String TYRKINA_STREET = "Петра Туркина";
    protected final static String STREET_TEST_LINE = "Тестовая линия";
    protected final static String HOME_NUMBER_ONE = "1";
    protected final static String HOME_NUMBER_THREE = "3";
    protected final static String FIRST_TREE_LETTERS_OF_CITY_NAME = "Чел";
    protected final static String PRESS_HOLDER = "+7";
    protected final MainChelyabinskCityPage mainChelyabinskCityPage = new MainChelyabinskCityPage();
    protected final TariffSelectionChelyabinskCityPage tariffSelectionChelyabinskCityPage = new TariffSelectionChelyabinskCityPage();

    @BeforeMethod()
    @Parameters({"url"})
    public void setUpDriver(String url) {
        Browser.setUpDriver().get(url);
    }

    @AfterMethod
    public void tirDownDriver() {
        Browser.driverTearDown();
    }
}
