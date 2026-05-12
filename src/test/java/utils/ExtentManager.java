package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/report.html");
            spark.config().setDocumentTitle("E-Commerce Test Report");
            spark.config().setReportName("HCL Automation Results");
            spark.config().setTheme(Theme.DARK);
            spark.config().setEncoding("UTF-8");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project",  "E-Commerce Web App - HCL");
            extent.setSystemInfo("Tester",   "Karthik");
            extent.setSystemInfo("Framework","Selenium + TestNG + Maven");
            extent.setSystemInfo("Browser",  "Chrome");
        }
        return extent;
    }

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest(){
        return test.get();
    }
}