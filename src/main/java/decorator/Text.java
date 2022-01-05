package decorator;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

public class Text extends Element {

    public Text(WebElement webElement) {
        super(webElement);
    }

    public int getInt() {
        int number;
        new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.elementToBeClickable(webElement));
        number = Integer.parseInt(super.getText());
        return number;

    }

    @Override
    public String getValue() {
        return webElement.getAttribute("value");
    }
}
