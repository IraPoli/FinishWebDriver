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
        new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.attributeToBe(webElement,"aria-label","В корзине"));
    }

    @Override
    public String getValue() {
        return webElement.getAttribute("value");
    }
}