package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {
    @FindBy(xpath = "//button[contains(@class,'green button_size_large')]")
    private WebElement buyButton;

    public ItemPage() {

    }

    public void clickByButton() {
        buyButton.click();
    }
}
