package tests.indu;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static implementation.seleniumlogs.logger;
import static utility.UtilityMethods.*;

public class Test5 extends TestBase {

    @Test
    public void filters50Validation() throws Exception {
        search(driver);
        driver.findElement(By.xpath(jsonfile(file2,"settings"))).click();
        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.xpath("(//select)[2]"));
        ele.click();
        Select opt = new Select(ele);
        opt.selectByValue("50");
        driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Back']")).click();
        Thread.sleep(3000);
        List<WebElement> l = driver.findElements(By.xpath(jsonfile(file2,"story")));
        if (l.size() == 50) {link_test.pass("successful");
        } else {
            link_test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
        }
        logger.info("succesfully loaded 50 titles");
    }
}
