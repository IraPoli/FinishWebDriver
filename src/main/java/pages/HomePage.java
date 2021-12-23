package pages;


import decorator.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropertiesReader;


public class HomePage extends BasePage {



    //@FindBy(tagName = "//input[contains(@class,'search-form')]")
    @FindBy(css = "input[name = 'search']")       //CSS
    private TextInput textSearchField;


   // @FindBy(xpath = "//input[contains(@class,'search-form')]")
   // private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,' search-form__submit')]")
    private WebElement searchButton;

///POM!
    By inputField = By.xpath("//input[contains(@class,'search-form')]");
////
    public HomePage() {
        PropertiesReader propertiesReader = new PropertiesReader();
        driver.get(propertiesReader.getUrl());
        logger.info("navigate to Url" + propertiesReader.getUrl());
    }

    public void enterTextToSearchField(final String searchText) {

        /////POM!
        TextInput searchField = new TextInput(driver.findElement(inputField));
        searchField.sendKeysInEmptyField(searchText, Keys.ENTER);
        ////
       // textSearchField.sendKeysInEmptyField(searchText,Keys.ENTER);
        logger.info( " Enter search " + searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
