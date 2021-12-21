package test;

import model.FilterRozetka;
import model.FiltersRozetka;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CurtPage;
import pages.HomePage;
import pages.SearchResultPage;
import utils.WebDriverSingleton;
import utils.XMLToObject;

import java.util.List;


    public class Parallel {
        HomePage homePage;
        SearchResultPage searchResultPage;
        CurtPage curtPage;

        private static final long DEFAULT_WAITING_TIME = 90;

        @DataProvider(name = "data")//, parallel = true)
        public static Object[] getData() {
            XMLToObject xmlToObject = new XMLToObject();
            FiltersRozetka filtersRozetka = xmlToObject.convert();
            List<FilterRozetka> list = filtersRozetka.getFilters();
            return list.toArray();
        }


        @Test(dataProvider = "data")
        public void parallel(FilterRozetka filterRozetka) throws Exception {
           int testId = filterRozetka.getId();


            homePage = new HomePage();
            homePage.enterTextToSearchField(filterRozetka.getItemName());
            homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);

            searchResultPage = new SearchResultPage();
            searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
           // searchResultPage.scrollToElem(null);
           // searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
           // searchResultPage.waitForAjaxToComplete(DEFAULT_WAITING_TIME);
           // searchResultPage.selectBrand(brand);
            searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
            searchResultPage.scrollTo(null);
            searchResultPage. clickBuyButtonFirst();
            searchResultPage. scrollToBottom(null);
            searchResultPage.clickOpenCartButton();
            searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);

            curtPage = new CurtPage();
            curtPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
            curtPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME,curtPage.getSumWebElement());
            int sumPrice = curtPage.getSumPrice();
            curtPage.takeSnapShot("./screenshots/testParallel_" + testId + ".png");
            Assert.assertTrue(sumPrice > filterRozetka.getSumLimit());

        }


     @AfterMethod(alwaysRun = true)
        public void close() {
          WebDriverSingleton.close();
        }


    }

