package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.DataProviders;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void testLogin(String email, String password) {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickSignupLogin();
        loginPage.login(email, password);

        if(email.equals("karthikrajan2210@gmail.com")) {
            Assert.assertTrue(loginPage.isLogoutVisible());
        } else {
            Assert.assertTrue(
                    loginPage.getLoginErrorMessage().contains("incorrect")
            );
        }
    }
}