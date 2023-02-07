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
        new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.visibilityOf(webElement));
        number = Integer.parseInt(super.getText().replaceAll("₴|\s", ""));
        return number;

    }

    @Override
    public String getValue() {
        return webElement.getAttribute("value");
    }
}
