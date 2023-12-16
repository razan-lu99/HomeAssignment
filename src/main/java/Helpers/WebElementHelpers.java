package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebElementHelpers {

    private static WebDriver driver;
    private static WebDriverWait wait;


    public static WebElement elementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void elementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static String getTextFromElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public static void waitForTime(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

