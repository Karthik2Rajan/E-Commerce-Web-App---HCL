package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutFlow() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        homePage.clickSignupLogin();

        loginPage.login(
                "karthikrajan2210@gmail.com",
                "Appamma@123"
        );

        productPage.openProductsPage();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        productPage.goToCart();

        Assert.assertTrue(cartPage.isCartDisplayed());

        checkoutPage.proceedToCheckout();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());

        checkoutPage.enterComment("Hackathon test order");
        checkoutPage.clickPlaceOrder();

        checkoutPage.enterPaymentDetails();
        checkoutPage.confirmPayment();

        Assert.assertTrue(checkoutPage.isOrderSuccessful());
    }
}