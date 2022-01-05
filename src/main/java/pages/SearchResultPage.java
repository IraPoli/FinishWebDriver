package pages;

import decorator.AddToCurtButton;
import decorator.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import java.util.List;
import java.util.Objects;


public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@data-filter-name='producer']")
    private WebElement priceFilter;

    @FindBy(xpath = "//div[@data-filter-name='seller']")
    private WebElement brandLabelHeader;


    @FindBy(xpath = "//div[@data-filter-name='producer']//label")
    private List<WebElement> producerList;


    @FindBy(css = " [class='catalog-settings ng-star-inserted']") //CSS
    private WebElement topOfPage;



    @FindBy(xpath = " //div[@data-filter-name='producer']//li")
    private List<Button> producerL;

    JavascriptExecutor je = (JavascriptExecutor) driver;

    //****
    @FindBy(xpath= "//button[@ aria-label=\"Купить\"]")
    private List<AddToCurtButton> allButtons;

    //****

    @FindBy(xpath= "//button[@ aria-label=\"Купить\"]")
    private Button buyButton;


    @FindBy(xpath = "//button[@opencart]")
    private Button openCurtSafeButton;


    ///POM!
    By openCurtSafe = By.xpath("//button[@opencart]");
    By addToBasketFirstItem = By.xpath("//ul[contains(@ class, 'catalog-grid')]//button[contains(@class,'buy-button')][1]");
    ////



    public SearchResultPage() {

    }



    public SearchResultPage clickOpenCartButton() {
        ///POM!!
        Button openCurtSafePOMButton = new Button(driver.findElement(openCurtSafe));
        openCurtSafePOMButton.castClick();

        ////
        // openCurtSafeButton.castClick();
          logger.info(" Open Curt page");
          return this;
    }


    public void selectBrand(String brandName) {

        WebElement webElementBrand = producerList.stream().filter(e -> e.getText().contains(brandName)).findAny().orElse(null);
        Objects.requireNonNull(webElementBrand).click();

    }

    public WebElement getBrandLabelHeader() {
        return brandLabelHeader;
    }
    public void selectBrandCustom(String brandName) {
        Button b = producerL.stream().filter(e -> e.getText().contains(brandName)).findAny().orElse(null);
        assert b != null;
        b.castClick();

    }

    public SearchResultPage clickBuyButtonFirst(){


        /////POM!
     //      AddToCurtButton addToBasketFirst = new AddToCurtButton(driver.findElement(addToBasketFirstItem));
      //    addToBasketFirst.castClick();



      //  addToBasketFirstButton.castClick();

//***

        new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.elementToBeClickable(buyButton));
              AddToCurtButton addToBasketFirst = allButtons.get(0);
              addToBasketFirst.castClick();
 //***
        logger.info( " add first item ");

        return this;
    }


    public SearchResultPage scrollTo(WebElement element) {

        je.executeScript("arguments[0].scrollIntoView(true);", element);
        logger.info( " scroll to element ");
        return this;
    }

    public WebElement getsTopOfPage() {
        return topOfPage;
    }
    public WebElement getPriceFilterEl() {
        return priceFilter;
    }

}
