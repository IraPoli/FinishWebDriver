package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
            instance.manage().window().maximize();
            instance.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
           // instance.get(propertiesReader.getUrl());
            webDriverThreadLocal.set(instance);
        }
        return webDriverThreadLocal.get();
    }
/////////////
    public static WebDriver currentDriver(){
        return webDriverThreadLocal.get();
    }
  /////////////
    public static void close() {
       // webDriverThreadLocal.get().close();
        try {
            webDriverThreadLocal.get().quit();
        } catch (Exception e) {
            System.err.println("ERROR: Can't close WebDriver");
        } finally {
            webDriverThreadLocal.remove();
        }

    }
}