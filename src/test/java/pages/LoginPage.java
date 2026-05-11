package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");

    private By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private By loginPassword = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");

    private By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
    private By loginError = By.xpath("//p[contains(text(),'incorrect')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        click(signupLoginBtn);
    }

    public void login(String email, String password) {
        type(loginEmail, email);
        type(loginPassword, password);
        click(loginBtn);
    }

    public boolean isLogoutVisible() {
        return isDisplayed(logoutBtn);
    }

    public String getLoginErrorMessage() {
        return getText(loginError);
    }

    public void logout() {
        click(logoutBtn);
    }
}