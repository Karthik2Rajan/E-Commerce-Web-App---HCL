package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By proceedToCheckoutBtn =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    private By checkoutText =
            By.xpath("//h2[contains(text(),'Address Details')]");

    private By commentBox =
            By.name("message");

    private By placeOrderBtn =
            By.xpath("//a[contains(text(),'Place Order')]");

    private By nameOnCard =
            By.name("name_on_card");

    private By cardNumber =
            By.name("card_number");

    private By cvc =
            By.name("cvc");

    private By expiryMonth =
            By.name("expiry_month");

    private By expiryYear =
            By.name("expiry_year");

    private By payBtn =
            By.id("submit");

    private By successMsg =
            By.xpath("//b[contains(text(),'Order Placed!')]");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        click(proceedToCheckoutBtn);
    }

    public boolean isCheckoutPageDisplayed() {
        return isDisplayed(checkoutText);
    }

    public void enterComment(String comment) {
        type(commentBox, comment);
    }

    public void clickPlaceOrder() {
        click(placeOrderBtn);
    }

    public void enterPaymentDetails() {
        type(nameOnCard, "Karthik Rajan");
        type(cardNumber, "4111111111111111");
        type(cvc, "123");
        type(expiryMonth, "12");
        type(expiryYear, "2030");
    }

    public void confirmPayment() {
        click(payBtn);
    }

    public boolean isOrderSuccessful() {
        return isDisplayed(successMsg);
    }
}