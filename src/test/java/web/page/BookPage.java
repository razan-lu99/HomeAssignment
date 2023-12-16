package web.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static Helpers.WebElementHelpers.*;
import java.util.List;

public class BookPage {

    public BookPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div/div/div/div[2]/div/div/div/ul/li/a[1]/h3")
    private List<WebElement> allBooks;

    @FindBy(xpath = "//div[2]/div/div/ul/li/a[contains(@href, 163)]")
    private WebElement addThinkingInHTMLBookToBasketBtn;

    @FindBy(xpath = "//div/div/div/ul/li/a[1]/span[contains(@class, 'price')]")
    private List<WebElement> prices;

    @FindBy(className = "cartcontents")
    private WebElement basketCount;

    @FindBy(xpath = "//div[1]/header/div[2]/nav/ul/li[6]/a")
    private WebElement shoppingCart;

    @FindBy(xpath = "//table")
    private WebElement tableInsideShoppingCart;

    @FindBy(xpath = "//div[2]/div[2]/div/div/ul/li/a[1]/h3")
    private WebElement bookName;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]/a")
    private WebElement bookNameInCart;

    @FindBy(xpath = "//div/div/div/div[2]/div[2]/div/div/ul/li/a[1]/span[2]/ins/span")
    private WebElement bookPrice;

    @FindBy(xpath = "//table/tbody/tr[1]/td[4]/span")
    private WebElement bookPriceInCart;

    @FindBy(className = "checkout-button")
    private WebElement proceedBtn;

    @FindBy(xpath = "//form[3]/div[1]/div[1]/div/h3")
    private WebElement elementInBill;

    @FindBy(className = "woocommerce")
    private WebElement billingForm;

    @FindBy(xpath = "//div[1]/div/a/img")
    private WebElement main;

    public boolean checkBooks() {
        boolean result = false;
        waitForTime(2000);
        for (int i = 0; i < allBooks.size(); i++){
            if (this.allBooks.get(i).getText().equalsIgnoreCase("Thinking in HTML") && this.prices.get(i).isDisplayed()){
                result = true;
            }
        }
        return result;
    }

    public boolean addThinkingInHTMLBookToBasketBtn(){
        this.addThinkingInHTMLBookToBasketBtn.click();
        waitForTime(1000);
        return this.basketCount.getText().equalsIgnoreCase("1 Item");
    }

    public boolean clickOnShoppingCart(){
        this.addThinkingInHTMLBookToBasketBtn();
        waitForTime(4000);
        this.shoppingCart.click();
        return this.tableInsideShoppingCart.isDisplayed();
    }

    public String getBookNameBeforeCart(){

        return this.bookName.getText();

    }

    public String getBookNameAfterCart(){

        this.addThinkingInHTMLBookToBasketBtn.click();
        waitForTime(3000);
        this.shoppingCart.click();
        return this.bookNameInCart.getText();

    }

    public String getBookPriceBeforeCart(){
        this.main.click();
        return this.bookPrice.getText();

    }

    public String getBookPriceAfterCart(){

        this.addThinkingInHTMLBookToBasketBtn.click();
        waitForTime(3000);
        this.shoppingCart.click();
        return this.bookPriceInCart.getText();

    }

    public boolean clickProceedBtn(){
        this.addThinkingInHTMLBookToBasketBtn.click();
        waitForTime(3000);
        this.shoppingCart.click();
        this.proceedBtn.click();
        waitForTime(1000);

        return this.elementInBill.getText().contains("Billing");

    }

    public boolean billingForm(){
        this.addThinkingInHTMLBookToBasketBtn.click();
        waitForTime(3000);
        this.shoppingCart.click();
        this.proceedBtn.click();
        waitForTime(1000);

        return this.billingForm.isDisplayed();

    }

}
