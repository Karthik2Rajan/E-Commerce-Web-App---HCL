package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    /**
     * Captures a screenshot and saves it under screenshots/<testName>_<timestamp>.png
     * Returns the relative path so ExtentReport can embed it.
     */
    public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String relativePath = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            // create screenshots/ folder if it doesn't exist
            File screenshotDir = new File("screenshots");
            if (!screenshotDir.exists()) screenshotDir.mkdirs();

            File srcFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(relativePath);
            FileUtils.copyFile(srcFile, destFile);

            System.out.println("[ScreenshotUtil] Saved → " + relativePath);
        } catch (IOException e) {
            System.err.println("[ScreenshotUtil] Failed to save screenshot: " + e.getMessage());
        }

        return relativePath;
    }
}