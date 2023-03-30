package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import static utility.UtilityMethods.*;

public class TestBase {
    public static ExtentReports extent;
    public static ExtentTest link_test;
    public static ExtentSparkReporter spark;
    public static WebDriver driver;
    public String file1="/Users/kinduvadana/Desktop/credentials.json";
    public String file2="/Users/kinduvadana/Desktop/webelements.json";
    @BeforeSuite
    public void beforeSuite() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://news.ycombinator.com/");
        driver.manage().window().maximize();
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
        extent.attachReporter(spark);

    }

    @BeforeMethod
    public void beforeMethod(Method method) throws Exception{
        link_test = extent.createTest(method.getName());


    }



    @AfterSuite
    public void afterSuite() {
        driver.close();
        extent.flush();
    }
}
