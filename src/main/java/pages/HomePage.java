package pages;

//import factoryDecorator.TextInput;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesReader;

public class HomePage extends BasePage {

   // @FindBy(tagName = "//input[contains(@class,'search-form')]")
   // private TextInput textSearchField;


    @FindBy(xpath = "//input[contains(@class,'search-form')]")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,' search-form__submit')]")
    private WebElement searchButton;




    public HomePage() {
        PropertiesReader propertiesReader = new PropertiesReader();
        driver.get(propertiesReader.getUrl());
    }

    public void enterTextToSearchField(final String searchText) {
        logger.info( " Enter search " + searchText);
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);

    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void enterTextSearchField(final String searchText){
        logger.info("Enter search " + searchText);
    //    textSearchField.sendKeysInEmptyField(searchText);

    }


}
