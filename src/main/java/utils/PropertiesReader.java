package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    Properties property = new Properties();

    public PropertiesReader() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("src/main/resources/config.properties");
            property.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            // logger.info("Property file is not exist");
            // e.printStackTrace();
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }

    public String getUrl() {
        return property.getProperty("URL");
    }

    public String getDriverName() {
        return property.getProperty("CHROME_DRIVER_NAME");
    }

    public String getDriverLocation() {
        return property.getProperty("CHROME_DRIVER_LOCATIONS");
    }

}