package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.CurtPage;
import utils.WebDriverSingleton;

import java.io.File;
import java.io.IOException;

public class MyListener implements ITestListener {
    CurtPage curtPage;

    @Override
    public void onFinish(ITestContext contextFinish) {
        System.out.println("onFinish method finished");

    }

    @Override
    public void onStart(ITestContext contextStart) {
        System.out.println("onStart method started ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Method failed with certain success percentage "+ result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed " + result.getName());
        String methodName = result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        WebDriver driver = WebDriverSingleton.getInstance();
        takeScreenShot(methodName, driver);
    }

    public void takeScreenShot(String methodName, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./screenshots/FailedTest " + methodName + ".png"));
            System.out.println("**************************************************************************");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Method skipped "+ result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Method started "+ result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed "+ result.getName());
    }

}