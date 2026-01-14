package utils;

import com.aventstack.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static utils.DriverFactory.getDriver;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        // Take screenshot
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String dest = "test-output/screenshots/" + result.getMethod().getMethodName() + ".png";
        try {
            Files.createDirectories(new File("test-output/screenshots").toPath());
            Files.copy(src.toPath(), new File(dest).toPath());
            test.get().addScreenCaptureFromPath(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
