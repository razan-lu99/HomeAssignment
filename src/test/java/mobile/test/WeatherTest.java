package mobile.test;

import base.MobileBaseTest;
import mobile.page.WeatherPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherTest extends MobileBaseTest {

    WeatherPage weatherPage;
    @Test(description = "Changing Temperature unit from C to F, along with proper assertions on main Weather screen")
    public void changeTempUnit(){
        weatherPage = new WeatherPage(driver);
        Assert.assertTrue(weatherPage.setWeatherUnit());
    }

    @Test(description = "Changing Time format from 24 to 12, along with proper assertions on main Weather screen")
    public void changeTimeFormat(){
        weatherPage = new WeatherPage(driver);
        Assert.assertTrue(weatherPage.setTimeFormat());
    }

    @Test(description = "Assertion that Chance of rain (raining icon) and Humidity (waterdrop icon) values are displayed for each hour in the next 6 hours")
    public void checkIconsVisibility(){
        weatherPage = new WeatherPage(driver);
        Assert.assertTrue(weatherPage.iconCheck());
    }

}

