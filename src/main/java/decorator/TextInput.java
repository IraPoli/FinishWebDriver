package decorator;

import org.openqa.selenium.WebElement;

public class TextInput extends Element {
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeysInEmptyField(CharSequence... charSequences) {
        super.webElement.clear();
        super.webElement.sendKeys(charSequences);
    }

    @Override
    public String getValue() {
        return webElement.getAttribute("value");
    }


}


