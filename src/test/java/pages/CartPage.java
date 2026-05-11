package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartTable = By.id("cart_info");
    private By removeBtn = By.className("cart_quantity_delete");
    private By emptyCartMessage = By.xpath("//b[contains(text(),'Cart is empty')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartDisplayed() {
        return isDisplayed(cartTable);
    }

    public void removeProduct() {
        click(removeBtn);
    }

    public boolean isCartEmpty() {
        return isDisplayed(emptyCartMessage);
    }
}