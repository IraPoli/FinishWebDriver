package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() == null) {
            WebDriver instance;
            PropertiesReader propertiesReader = new PropertiesReader();
            String driverName = propertiesReader.getDriverName();
            String driverLocation = propertiesReader.getDriverLocation();
            System.setProperty(driverName, driverLocation);
            instance = new ChromeDriver();
            //  instance = new FirefoxDriver();
            instance.manage().window().maximize();
            instance.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
            webDriverThreadLocal.set(instance);
        }
        return webDriverThreadLocal.get();
    }

    public static void close() {

        try {
            if (webDriverThreadLocal != null) {
                webDriverThreadLocal.get().quit();
            }
        } catch (Exception e) {
            System.err.println("ERROR: Can't close WebDriver");
        } finally {
            webDriverThreadLocal.remove();
        }

    }
}