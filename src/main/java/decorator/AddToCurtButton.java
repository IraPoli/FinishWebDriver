package decorator;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import static java.lang.Thread.sleep;

public class AddToCurtButton extends Element {

    public AddToCurtButton(WebElement webElement) {
        super(webElement);
    }

    public void castClick() throws InterruptedException {
     /*   WebDriver driver;
        driver = WebDriverSingleton.getInstance();
        JavascriptExecutor je = (JavascriptExecutor) driver;*/
        if (!isAdded()) {

            try {
                super.click();
            } catch (ElementClickInterceptedException e) {
                new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.elementToBeClickable(webElement));
            }
            // je.executeScript("arguments[0].click()", super.webElement);
        }
       if(!isAdded()){
           sleep(30);
       }
    }

    public boolean isAdded() {

        String str = super.getAttribute("aria-label");
        return str.equals("В корзине");
    }
}