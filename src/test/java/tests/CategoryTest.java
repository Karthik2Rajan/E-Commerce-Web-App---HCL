package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class CategoryTest extends BaseTest {

    @Test
    public void testCategoryNavigation() {

        ProductPage productPage = new ProductPage(driver);

        productPage.openProductsPage();
        productPage.openWomenCategory();

        Assert.assertTrue(productPage.isCategoryProductVisible());
    }
}