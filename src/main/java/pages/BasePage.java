package pages;

import decorator.CustomFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;
import java.io.File;

public class BasePage {
    WebDriver driver;
    Logger logger;

    public BasePage() {
        driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        logger = LogManager.getLogger(BasePage.class);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitVisibilityOfElementTest(long timeToWait, WebElement element) {
        new WebDriverWait(WebDriverSingleton.getInstance(), 30).until(ExpectedConditions.elementToBeClickable(element));
    }


    public void takeSnapShot(String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);
        FileUtils.copyFile(srcFile, destFile);
    }


}
