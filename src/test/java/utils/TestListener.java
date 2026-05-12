package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentTest extentTest = extent.createTest(testName);
        ExtentManager.setTest(extentTest);
        System.out.println("[TestListener] Started → " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, "✅ Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = ExtentManager.getTest();

        // Log the exception
        extentTest.log(Status.FAIL, "❌ Test Failed: " + result.getThrowable().getMessage());
        extentTest.fail(result.getThrowable());

        // Capture screenshot via BaseTest's driver field
        try {
            WebDriver driver = getDriverFromTest(result);
            if (driver != null) {
                String screenshotPath = ScreenshotUtil.captureScreenshot(
                        driver, result.getMethod().getMethodName());

                // Attach screenshot to the report
                // Path is relative to reports/ folder where report.html lives
                extentTest.fail("Screenshot on failure:",
                        MediaEntityBuilder
                                .createScreenCaptureFromPath("../" + screenshotPath)
                                .build());
            }
        } catch (Exception e) {
            extentTest.log(Status.WARNING,
                    "⚠️ Screenshot could not be captured: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, "⚠️ Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // ← writes report.html to disk
        System.out.println("[TestListener] Report generated → reports/report.html");
    }

    // -------------------------------------------------------
    // Utility: walks up the class hierarchy to find 'driver'
    // -------------------------------------------------------
    private WebDriver getDriverFromTest(ITestResult result) throws Exception {
        Object instance = result.getInstance();
        Class<?> clazz = instance.getClass();

        // Walk up to BaseTest if driver is declared there
        while (clazz != null) {
            try {
                Field driverField = clazz.getDeclaredField("driver");
                driverField.setAccessible(true);
                return (WebDriver) driverField.get(instance);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass(); // try parent class
            }
        }
        return null;
    }
}