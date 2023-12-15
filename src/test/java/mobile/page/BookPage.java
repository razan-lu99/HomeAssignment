package mobile.page;


import base.MobileBaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

public class BookPage extends MobileBaseTest {

    public BookPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    @AndroidFindBy()
    private Element firstelement;



}
