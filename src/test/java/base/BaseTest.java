package base;

import io.appium.java_client.gecko.GeckoDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
            String browser = System.getProperty("browser", "chrome").toLowerCase();

            if (browser.equals("firefox")){
                System.getProperty("webdriver.gecko.driver", "C:\\Program Files\\firefox.exe");
                driver = new FirefoxDriver();
            }
            if (browser.equals("chrome")) {
                System.setProperty("chrome", "C:\\Program Files\\Google\\Chrome\\Application\\chrome-win32\\chrome-win32\\chrome.exe");
                driver = new ChromeDriver();
            }

        driver.get("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

