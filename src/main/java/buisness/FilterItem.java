package buisness;

import model.FilterRozetka;
import pages.HomePage;
import pages.SearchResultPage;

import static java.lang.Thread.sleep;

public class FilterItem {
    HomePage homePage;
    SearchResultPage searchResultPage;
    private static final long DEFAULT_WAITING_TIME = 90;

    public void applyFilters(FilterRozetka filterRozetka) throws InterruptedException {
        sleep(1300);
        homePage = new HomePage();
        sleep(2000);
        homePage.enterTextToSearchField(filterRozetka.getItemName());
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        sleep(1000);
        searchResultPage = new SearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        //sleep(1400);

     //   searchResultPage.scrollTo(searchResultPage.getPriceFilterEl());
     //  searchResultPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME,searchResultPage.getBrandLabelHeader());

    //    searchResultPage.selectBrandCustom(filterRozetka.getBrand());


        searchResultPage.scrollTo(searchResultPage.getsTopOfPage())
                        .clickBuyButtonFirst()
                        .clickOpenCartButton();

    }
}
