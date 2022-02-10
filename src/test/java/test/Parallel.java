package test;

import buisness.CartData;
import buisness.FilterItem;
import model.FilterRozetka;
import model.FiltersRozetka;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.WebDriverSingleton;
import utils.XMLToObject;

import java.util.List;

@Listeners(listeners.MyListener.class)
public class Parallel {

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

        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(new CartData().getSumOrder(filterRozetka.getId()) > filterRozetka.getSumLimit());
        assertion.assertAll();
        //  Assert.assertTrue(new CartData().getSumOrder(filterRozetka.getId()) > filterRozetka.getSumLimit());
    }


    @AfterMethod(alwaysRun = true)
    public void close() {
        WebDriverSingleton.close();
    }
}