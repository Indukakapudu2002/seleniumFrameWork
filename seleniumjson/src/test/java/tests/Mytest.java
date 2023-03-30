package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utility.UtilityMethods;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
public class Mytest
{
         public ExtentReports extent;
         public ExtentTest link_test;
          public ExtentSparkReporter spark;
        @BeforeSuite
        public void beforesuite ()
        {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
            extent.attachReporter(spark);
        }
        @BeforeMethod
        public void beforemethod (Method method)
        {
            link_test = extent.createTest(method.getName());
        }
        @AfterSuite
        public void Aftersuite ()
        {
            extent.flush();
        }

}



