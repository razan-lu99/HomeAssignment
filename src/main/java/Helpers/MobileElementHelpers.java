package Helpers;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.MobileBaseTest.driver;

public class MobileElementHelpers {

    private static final int waitInSeconds = 20;
    static WebDriverWait wait = new WebDriverWait(driver, 10);

    public static void elementToBeVisible(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void elementToBeClickable(AndroidElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static  void waitForAlertToBePresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForTime(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void swipeElementLeft(int elementX, AndroidElement elementToScroll) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(elementX - 400, elementToScroll.getCenter().getY())).release().perform();
    }

    public static void swipeByCoordinates(int startX, int startY, int endX, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // Optional: Add wait time if needed
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
}
