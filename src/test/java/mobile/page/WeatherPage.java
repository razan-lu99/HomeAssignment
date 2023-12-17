package mobile.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Helpers.MobileElementHelpers.*;


public class WeatherPage {

    public WeatherPage(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    @AndroidFindBy(id = "com.info.weather.forecast:id/iv_temp_dropdown")
    private AndroidElement tempOptionsDropdown;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")
    private AndroidElement fBtn;

    @AndroidFindBy(id = "com.info.weather.forecast:id/tv_button_done")
    private AndroidElement doneBtn;

    @AndroidFindBy(id = "com.info.weather.forecast:id/ll_got_it")
    private AndroidElement gotPrivacyPolicy;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private AndroidElement allowLocationOnForeground;

    @AndroidFindBy(id = "com.info.weather.forecast:id/tv_current_temper_unit")
    private AndroidElement currentUnit;

    @AndroidFindBy(id = "com.info.weather.forecast:id/iv_timeformat_dropdown")
    private AndroidElement timeFormatOptionsDropdown;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    private AndroidElement twelveBtn;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
    private AndroidElement times;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
    private List<AndroidElement> firstFiveRainChance;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
    private AndroidElement sixthRainChance;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
    private List<AndroidElement> firstFiveHumidity;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private AndroidElement sixthHumidity;
    
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout")
    private AndroidElement elementToScroll;

    public boolean setWeatherUnit(){
        elementToBeVisible(this.tempOptionsDropdown);
        this.tempOptionsDropdown.click();
        this.fBtn.click();
        this.doneBtn.click();
        waitForTime(1000);
        if (this.gotPrivacyPolicy.isDisplayed()) {
            this.gotPrivacyPolicy.click();
        }
        if (this.allowLocationOnForeground.isDisplayed()) {
            this.allowLocationOnForeground.click();
        }
        elementToBeVisible(this.currentUnit);
        return this.currentUnit.getText().contains("F");
    }

    public boolean setTimeFormat(){
        elementToBeVisible(this.timeFormatOptionsDropdown);
        this.timeFormatOptionsDropdown.click();
        this.twelveBtn.click();
        this.doneBtn.click();
        waitForTime(1000);
        if (this.gotPrivacyPolicy.isDisplayed()) {
            this.gotPrivacyPolicy.click();
        }
        if (this.allowLocationOnForeground.isDisplayed()) {
            this.allowLocationOnForeground.click();
        }
        elementToBeVisible(this.times);
        if (this.times.getText().contains("am") || this.times.getText().contains("pm")){
            return true;
        } else {
            return false;
        }
    }

    public boolean iconCheck(){
        elementToBeVisible(this.doneBtn);
        this.doneBtn.click();
        if (this.gotPrivacyPolicy.isDisplayed()) {
            this.gotPrivacyPolicy.click();
        }
        if (this.allowLocationOnForeground.isDisplayed()) {
            this.allowLocationOnForeground.click();
        }
        elementToBeVisible(this.elementToScroll);
        int elementX = this.elementToScroll.getLocation().getX();
        swipeElementLeft(elementX, elementToScroll);
        waitForTime(1000);
        this.firstFiveRainChance.add(this.sixthRainChance);
        this.firstFiveHumidity.add(this.sixthHumidity);
        boolean checkThem = false;
        for (int i = 0 ; i < 6 ; i++){
            if (this.firstFiveRainChance.get(i).getText().contains("%") && this.firstFiveHumidity.get(i).getText().contains("%")){
                checkThem = true;
            }
        }
        return checkThem;
    }
}
