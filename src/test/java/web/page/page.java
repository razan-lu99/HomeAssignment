package web.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class page {

    public page(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy()
    private WebElement firstelement;

}
