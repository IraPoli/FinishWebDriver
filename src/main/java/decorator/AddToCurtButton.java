package decorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

public class AddToCurtButton extends Element  {

    public AddToCurtButton(WebElement webElement) {
        super(webElement);
    }
    public void castClick() {
        new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.elementToBeClickable(webElement));
        super.click();
        new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.attributeToBe(webElement,"class","buy-button goods-tile__buy-button ng-star-inserted buy-button_state_in-cart"));
    }
    @Override
    public String getValue() {
        return webElement.getAttribute("value");
    }
}