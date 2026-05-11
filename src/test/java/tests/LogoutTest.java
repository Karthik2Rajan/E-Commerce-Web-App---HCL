package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickSignupLogin();

        loginPage.login(
                "karthikrajan2210@gmail.com",
                "Appamma@123"
        );

        homePage.clickLogout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}