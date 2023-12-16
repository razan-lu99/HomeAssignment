package web.test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import web.page.BookPage;


public class BookTest extends BaseTest {

    BookPage bookPage;

    @Test(description = "Asserting Thinking in HTML book exists along with its price")
    public void assertingThinkingInHTMLBookExistsWithPrice() {

        bookPage= new BookPage(driver);
        Assert.assertTrue(bookPage.checkBooks());

    }

    @Test (description = "Clicking on Add to Basket for Thinking in HTML book")
    public void clickingOnAddToBasketForThinkingInHTMLBook() {

        bookPage= new BookPage(driver);
        Assert.assertTrue(bookPage.addThinkingInHTMLBookToBasketBtn());

    }

    @Test (description = "Clicking on Shopping Cart")
    public void clickingOnShoppingCart() {

        bookPage= new BookPage(driver);
        Assert.assertTrue(bookPage.clickOnShoppingCart());
    }

    @Test (description = "Asserting Item added to cart with its details")
    public void assertingItemAddedToCartWithDetails() {

        bookPage= new BookPage(driver);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(bookPage.getBookNameBeforeCart(), bookPage.getBookNameAfterCart());
        softAssert.assertEquals(bookPage.getBookPriceBeforeCart(), bookPage.getBookPriceAfterCart());

        softAssert.assertAll();

    }

    @Test (description = "Clicking on Proceed to Checkout")
    public void clickingOnProceedToCheckout() {

        bookPage= new BookPage(driver);
        Assert.assertTrue(bookPage.clickProceedBtn());

    }

    @Test (description = "Assert Billing Details form displayed")
    public void assertBillingDetailsFormDisplayed() {

        bookPage= new BookPage(driver);
        Assert.assertTrue(bookPage.billingForm());
    }


}
