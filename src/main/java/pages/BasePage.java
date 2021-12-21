package pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;
import utils.WebDriverSingleton;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    Logger logger;

    public BasePage() {
        driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
        logger = LogManager.getLogger(BasePage.class);


    }

    public void waitForPageLoadComplete(long timeToWait) {
     /*   Wait waitFluent = new FluentWait(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        waitFluent.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));


*/
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));


    }

    public void waitForAjaxToComplete(long timeToWait) {
        new FluentWait(driver)
                .ignoring(NoSuchElementException.class)
               .until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }


    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
      //  wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitListLength(long timeToWait, WebElement element){
    //    WebDriverWait wait = new WebDriverWait(driver, timeToWait);
    //    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element,10));
    }

    public void waitElementToBeClickable(long timeToWait, WebElement element) {
      /*  new FluentWait(driver)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));*/
        //WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        //wait.until(ExpectedConditions.elementToBeClickable(element));

    }


   /* public void refresh() {
        driver.navigate().refresh();
    }*/

    public void takeSnapShot(String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);
        FileUtils.copyFile(srcFile, destFile);
    }




}
