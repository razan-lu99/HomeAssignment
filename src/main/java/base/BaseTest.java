package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("chrome", "C:\\Program Files\\Google\\Chrome\\Application\\chrome-win32\\chrome-win32\\chrome.exe");
        driver = new ChromeDriver();
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

