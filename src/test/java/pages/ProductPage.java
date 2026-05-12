package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    private By searchBox = By.id("search_product");
    private By searchBtn = By.id("submit_search");

    private By firstAddToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    private By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private By cartBtn = By.xpath("//a[contains(text(),'Cart')]");

    private By womenCategory = By.xpath("//a[@href='#Women']");
    private By firstCategoryProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");

    private By firstViewProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private By productName = By.xpath("//div[@class='product-information']/h2");
    private By productPrice = By.xpath("//div[@class='product-information']/span/span");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void openProductsPage() {
        click(productsBtn);
        waitForVisibility(searchBox);
    }

    public void searchProduct(String productNameText) {
        type(searchBox, productNameText);
        click(searchBtn);
    }

    public void addFirstProductToCart() {
        click(firstAddToCart);
    }

    public void continueShopping() {
        click(continueShopping);
    }

    public void goToCart() {
        click(cartBtn);
    }

    public void openWomenCategory() {
        click(womenCategory);
    }

    public boolean isCategoryProductVisible() {
        return isDisplayed(firstCategoryProduct);
    }

    public void openFirstProductDetail() {
        click(firstViewProduct);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }
}