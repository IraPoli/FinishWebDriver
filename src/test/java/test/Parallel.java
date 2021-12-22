package test;

import buisness.CartData;
import buisness.FilterItem;
import model.FilterRozetka;
import model.FiltersRozetka;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CurtPage;
import utils.WebDriverSingleton;
import utils.XMLToObject;

import java.util.List;

import static java.lang.Thread.sleep;


public class Parallel {
    //  HomePage homePage;
    //  SearchResultPage searchResultPage;
    // CurtPage curtPage;

    private static final long DEFAULT_WAITING_TIME = 90;

    @DataProvider(name = "data", parallel = true)
    public static Object[] getData() {
        XMLToObject xmlToObject = new XMLToObject();
        FiltersRozetka filtersRozetka = xmlToObject.convert();
        List<FilterRozetka> list = filtersRozetka.getFilters();
        return list.toArray();
    }


    @Test(dataProvider = "data")
    public void parallel(FilterRozetka filterRozetka) throws Exception {
        FilterItem filterItem = new FilterItem();

        filterItem.applyFilters(filterRozetka);

        Assert.assertTrue(new CartData().getSumOrder() > filterRozetka.getSumLimit());

    }


    @AfterMethod(alwaysRun = true)
    public void close() {
        WebDriverSingleton.close();
    }
}

