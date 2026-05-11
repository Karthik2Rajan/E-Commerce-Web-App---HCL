package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getTimeout())
        );
    }

    public void click(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void type(By locator, String text) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).sendKeys(text);
    }

    public String getText(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    public boolean isDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();
    }
}
