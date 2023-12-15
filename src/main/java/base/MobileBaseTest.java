package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class MobileBaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        Properties config = loadConfigProperties();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", config.getProperty("platform.name"));
        capabilities.setCapability("platformVersion", config.getProperty("platform.version"));
        capabilities.setCapability("app", config.getProperty("app.path"));

        URL appiumServerURL = new URL(config.getProperty("appium.server.url"));

        driver = new AndroidDriver(appiumServerURL, capabilities);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private Properties loadConfigProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return properties;
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
