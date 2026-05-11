package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private By signupName = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    private By password = By.id("password");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address = By.id("address1");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobile = By.id("mobile_number");
    private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    private By accountCreatedMsg = By.xpath("//b[contains(text(),'Account Created')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterSignupDetails(String name, String email) {
        type(signupName, name);
        type(signupEmail, email);
        click(signupBtn);
    }

    public void completeRegistration(String pass) {
        type(password, pass);
        type(firstName, "Karthik");
        type(lastName, "Rajan");
        type(address, "Salem");
        type(state, "Tamil Nadu");
        type(city, "Salem");
        type(zipcode, "636001");
        type(mobile, "9876543210");

        click(createAccountBtn);
    }

    public boolean isAccountCreated() {
        return isDisplayed(accountCreatedMsg);
    }
}