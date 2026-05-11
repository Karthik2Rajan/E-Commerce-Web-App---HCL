package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"karthikrajan2210@gmail.com", "Appamma@123"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String password) {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickSignupLogin();
        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isLoginSuccessful());
    }

    @Test
    public void testInvalidLogin() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickSignupLogin();
        loginPage.login("wrong@gmail.com", "wrong123");

        Assert.assertTrue(loginPage.isErrorVisible());
    }
}