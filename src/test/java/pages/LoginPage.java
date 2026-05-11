package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailField = By.xpath("//input[@data-qa='login-email']");
    private By passwordField = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");
    private By errorMessage = By.xpath("//p[contains(text(),'incorrect')]");
    private By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginBtn);
    }

    public boolean isErrorVisible() {
        return isDisplayed(errorMessage);
    }

    public boolean isLoginSuccessful() {
        return isDisplayed(loggedInUser);
    }
}