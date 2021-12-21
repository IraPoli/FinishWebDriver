package pages;

//import factoryDecorator.AddToCurtButton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.WebDriverSingleton;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class SearchResultPage extends BasePage {

   // @FindBy(tagName = "//ul[contains(@ class, 'catalog-grid')]//button[contains(@class,'buy-button')]")
   // private AddToCurtButton addToCurtButton;

   // @FindBy(xpath = "//div[@data-filter-name='price']")
   @FindBy(xpath = "//div[@data-filter-name='producer']")
    private WebElement priceFilter;



    //@FindBy(xpath = "/html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/aside/rz-filter-stack/div[3]/div")
    @FindBy(xpath = "/html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/aside/rz-filter-stack/div[2]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-checkbox/ul[1]/li[2]")
    private WebElement brandSideBar;





    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted' ]")
    private List<WebElement> productList;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted' ][4]")
    private WebElement productListEl4;





    @FindBy(xpath = " //ul[contains(@ class, 'catalog-grid')]//button[contains(@class,'buy-button')]")
    private List<WebElement> buyButtonList;

    @FindBy(xpath = " //ul[contains(@ class, 'catalog-grid')]//button[contains(@class,'buy-button')][1]")
    private WebElement buyButtonFirst;

    @FindBy(xpath = "//div[@data-filter-name='producer']//label")
    private List<WebElement> producerList;


    @FindBy(xpath = "//label[@for='Есть в наличии']")
    private WebElement availableLabel;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted' ]")
    private List<WebElement> itemList;


    @FindBy(xpath = "//button[@opencart]")
    private WebElement openCurtButton;


    @FindBy(xpath = " /html/body/app-root/div/div/rz-search/rz-catalog/div/div[1]/div")
    private WebElement topOfPage;


   // @FindBy(xpath = " /html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/section/rz-catalog-paginator/rz-load-more/a/span")
    @FindBy(xpath = "/html/body/app-root/div/rz-lazy")
    private WebElement bottomOfPage;



    @FindBy(xpath = "/html/body/app-root/div/div/rz-search/rz-catalog/div/div[2]/aside/rz-filter-stack/div[4]")
    private WebElement priceElement;

    JavascriptExecutor je = (JavascriptExecutor) driver;

    public SearchResultPage() {
    }

    public void selectFirstProduct() {
        productList.get(1).click();
    }

    public List<WebElement> getBuyButtonElement() {
        List<WebElement> el = buyButtonList;
        return buyButtonList;
    }

    public void addFirstProduct() {

        WebElement el = buyButtonList.get(1);
        el.click();
    }

    public void clickOpenCartButton() {

        logger.info(" Open Curt page");
        openCurtButton.click();
    }



    public void selectBrand(String brandName) throws InterruptedException {

        WebElement webElementBrand = producerList.stream().filter(e -> e.getText().contains(brandName)).findAny().orElse(null);
        webElementBrand.click();

    }



    public WebElement getAvailableLabelElement() {
        return availableLabel;
    }

    public void selectAvailableLabel() {
        availableLabel.click();
    }

    public void selectFirstItem() {
        itemList.get(0).click();
    }

    public void clickBuyButtonFirst() throws InterruptedException {


        logger.info(" Select first product to Curt");
        Wait waitfluent = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        waitfluent.until(ExpectedConditions.visibilityOf(buyButtonFirst));
        buyButtonFirst.click();

    }

    public WebElement getBrandSideBar() {
        return brandSideBar;
    }







    public void addItem(){
      //  String test = buyButtonFirst.getAttribute("aria-label");
        driver.navigate().refresh();

    //    addToCurtButton.addIfNotAdd();
        logger.info("add to Curt");

    }


    public void scrollToElem(WebElement element){
        element = priceFilter;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void scrollToBottom(WebElement element){

        element = bottomOfPage;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }


    public void scrollTo(WebElement element) throws InterruptedException {

        element = topOfPage;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void scrollToCartButton(WebElement element){
        element = openCurtButton;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }

}
