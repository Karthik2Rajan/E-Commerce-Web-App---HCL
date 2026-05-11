package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void testRemoveProductFromCart() {

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.openProductsPage();
        productPage.searchProduct("Blue Top");
        productPage.addFirstProductToCart();
        productPage.continueShopping();
        productPage.goToCart();

        Assert.assertTrue(cartPage.isCartDisplayed());

        cartPage.removeProduct();
    }
}