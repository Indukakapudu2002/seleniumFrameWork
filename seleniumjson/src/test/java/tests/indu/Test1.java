package tests.indu;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.IOException;

import static utility.UtilityMethods.getScreenshot;

public class Test1 extends TestBase {
    @Test
    public void pageValidation() throws IOException {
        if (driver.getTitle().equals("Hacker News")) {
            link_test.pass("webspage validated successfully");
        } else {
            //link_test.fail("invalid webpage");
            link_test.fail("invalid page",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
        }
    }
}
