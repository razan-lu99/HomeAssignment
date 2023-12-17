package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class MobileBaseTest {

    public static AppiumDriver driver;

    @BeforeMethod
    public void  setUp() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Jeeny Jordan\\IdeaProjects\\JeenyPassengerAndroid\\src\\main\\resources\\hms.properties");
        properties.load(fileInputStream);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, properties.getProperty("platformName"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.APP, properties.getProperty("app"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getProperty("platformVersion"));

        URL appiumServerURL = new URL(properties.getProperty("appiumServerURL"));
        driver = new AndroidDriver(appiumServerURL, capabilities);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
