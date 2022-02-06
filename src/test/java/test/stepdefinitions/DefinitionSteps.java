package test.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.After;

import org.testng.Assert;
import pages.CurtPage;
import pages.HomePage;
import pages.SearchResultPage;
import utils.WebDriverSingleton;

public class DefinitionSteps {
    CurtPage curtPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    private static final long DEFAULT_WAITING_TIME = 30;


    @Given("User makes search by keyword {string} at Rozetka")
    public void openPage(final String url) {
        homePage = new HomePage();
        homePage.enterTextToSearchField(url);
        homePage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
    }

    @And("User select filter brand {string}")
    public void selectFilter(final String brandName) {
        searchResultPage = new SearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);

        searchResultPage.scrollTo(searchResultPage.getPriceFilterEl());
        searchResultPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, searchResultPage.getBrandLabelHeader());

        searchResultPage.selectBrandCustom(brandName);

    }

    @When("User add first product to Cart.")
    public void addToCartFirstProduct() {
        searchResultPage.scrollTo(searchResultPage.getsTopOfPage())
                .clickBuyButtonFirst()
                .clickOpenCartButton();

    }


    @Then("User checks that item price is more then {string}")
    public void checkProductPrice(final String limit) {
        curtPage = new CurtPage();
        curtPage.waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        curtPage.waitVisibilityOfElement(DEFAULT_WAITING_TIME, curtPage.getSumWebElement());
        int sumPrice = curtPage.getSumPrice();
        Assert.assertTrue(sumPrice > Integer.parseInt(limit));

    }


    @After()
    public void close() {
        WebDriverSingleton.close();
    }

}
