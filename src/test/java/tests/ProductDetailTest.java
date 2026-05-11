package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductDetailTest extends BaseTest {

    @Test
    public void testProductDetails() {

        ProductPage productPage = new ProductPage(driver);

        productPage.openProductsPage();
        productPage.openFirstProductDetail();

        Assert.assertFalse(productPage.getProductName().isEmpty());
        Assert.assertFalse(productPage.getProductPrice().isEmpty());
    }
}