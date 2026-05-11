package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegistration() {

        String uniqueEmail =
                "user" + System.currentTimeMillis() + "@gmail.com";

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.clickSignupLogin();

        registerPage.enterSignupDetails(
                "Test User",
                uniqueEmail
        );

        registerPage.completeRegistration("Test@123");

        Assert.assertTrue(registerPage.isAccountCreated());
    }
}