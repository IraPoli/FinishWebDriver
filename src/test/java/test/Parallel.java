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
        private static final Logger logger = LogManager.getLogger(Parallel.class);//Logger.getLogger(PropertiesReader.


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
            String brand = filterRozetka.getBrand();


            homePage = new HomePage();
            homePage.enterTextToSearchField(filterRozetka.getItemName(),testId);
            homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);

            searchResultPage = new SearchResultPage();
            searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
          //  searchResultPage.scrollToElem(null);
           // searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);


           // searchResultPage.waitForAjaxToComplete(DEFAULT_WAITING_TIME);


         //   searchResultPage.selectBrand(brand);
            logger.info("Test-" + testId + " Select brand " + brand);

            searchResultPage.refresh();

            searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
           // searchResultPage.scrollTo(null);



            searchResultPage.refresh();
            searchResultPage. clickBuyButtonFirst(0);
            logger.info("Test-" + testId + " Select first product to Curt");


            //searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
            searchResultPage.scrollToCartButton(null);
            searchResultPage.refresh();
            searchResultPage.clickOpenCartButton(0);
            logger.info("Test-" + testId + " Open Curt page");
            searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
            curtPage = new CurtPage();

            int sumPrice = curtPage.getSumPrice(0);


            curtPage.takeSnapShot("./screenshots/testParallel_" + testId + ".png");
            Assert.assertTrue(sumPrice > filterRozetka.getSumLimit());
            logger.info("Test-" + testId + "Assert price " + sumPrice + " > " + filterRozetka.getSumLimit());
            curtPage.close();

        }


        @AfterMethod(alwaysRun = true)
        public void close() {
          WebDriverSingleton.close();
        }


    }

