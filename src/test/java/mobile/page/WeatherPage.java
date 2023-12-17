package mobile.page;

import io.appium.java_client.AppiumDriver;
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

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
    private AndroidElement times;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
    private List<AndroidElement> rainChance;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private List<AndroidElement> humidity;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]")
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
        return this.currentUnit.getText().toLowerCase().contains("f");
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

        System.out.println(this.times.getText());

        if (this.times.getText().toLowerCase().contains("am") || this.times.getText().toLowerCase().contains("pm")){
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
        waitForTime(3000);
        elementToBeVisible(this.elementToScroll);
        swipeByCoordinates(950, 1200, 820, 1200);

        boolean checkThem = false;
        System.out.println(this.humidity.get(0).getText());
        for (int i = 0 ; i < 6 ; i++){
            if (this.rainChance.get(i).getText().contains("%") && this.humidity.get(i).getText().contains("%")){
                checkThem = true;
            }
        }
        return checkThem;
    }
}
