package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartValidationTest extends BaseTest {

    @Test
    public void testCartValidation() {

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.openProductsPage();
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        productPage.goToCart();

        Assert.assertEquals(
                cartPage.getCartProductName(),
                "Blue Top"
        );

        Assert.assertFalse(
                cartPage.getCartProductPrice().isEmpty()
        );

        Assert.assertEquals(
                cartPage.getCartCount(),
                "1"
        );
    }
}