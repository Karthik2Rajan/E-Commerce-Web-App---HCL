package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignupLogin() {
        click(signupLoginBtn);
    }
    public void clickLogout() {
        click(logoutBtn);
    }
}