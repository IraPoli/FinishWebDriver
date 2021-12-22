package decorator;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

public class Button extends Element {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void castClick() {
        WebDriver driver;
        driver = WebDriverSingleton.getInstance();

        JavascriptExecutor je = (JavascriptExecutor) driver;


        try {
            super.click();
        }catch (ElementClickInterceptedException e){
            new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.elementToBeClickable(webElement));
        }

      //  je.executeScript("arguments[0].click()", webElement);
    }


}