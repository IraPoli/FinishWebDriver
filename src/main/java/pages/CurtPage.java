package pages;

import decorator.Text;
import decorator.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurtPage extends BasePage {

    @FindBy(xpath = "//div[@class= 'cart-receipt__sum-price']/span")
    private WebElement sumPrice;

    @FindBy(xpath = "//div[@class= 'cart-receipt__sum-price']/span")
    private Text textPrice;

    ///POM!
    By priceSum = By.xpath( "//div[@class= 'cart-receipt__sum-price']/span");
    ////


    public CurtPage() {

    }

    public int getSumPrice() {

       /*
        logger.info(" get sum price" +  price);
        */

        int price;
        /////POM!

      /// Text texLabel = new Text(driver.findElement(priceSum));
      //  price =texLabel.getInt();
        ////


        price = textPrice.getInt();
        return price;
    }

    public WebElement getSumWebElement() {
    return sumPrice;

    }


}
