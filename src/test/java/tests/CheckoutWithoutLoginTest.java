package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;

public class CheckoutWithoutLoginTest extends BaseTest {

    @Test
    public void testCheckoutWithoutLogin() {

        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        productPage.openProductsPage();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        productPage.goToCart();

        checkoutPage.proceedToCheckout();

        Assert.assertTrue(
                driver.getPageSource().contains("Register / Login")
        );
    }
}