package utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static implementation.seleniumlogs.logger;

public class UtilityMethods
{
    public static boolean flag=false;
    static JSONParser parser = new JSONParser();
    static Object obj;
    static JSONObject jsonobject;
    static JSONObject jsonobject1;
    static WebDriver driver;
    public static WebDriver driverimplementation()
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;


    }
    public static void getwebpage(WebDriver driver) throws Exception {
        String url=jsonfile("/Users/kinduvadana/Desktop/credentials.json","url");
        driver.get(url);
        String s=driver.getTitle();
        System.out.println(s);
        if(s.equalsIgnoreCase("Hacker news")) {
            flag = true;
            driver.manage().window().maximize();
        }
    }
    public static String jsonfile(String file,String s) throws Exception {
        FileReader fileReader = null;
        fileReader = new FileReader(file);
        obj = parser.parse(fileReader);
        jsonobject=(JSONObject) obj;
        fileReader.close();
        return (String)jsonobject.get(s);

    }
    public static String getScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String dest="screenshots/screenshot"+System.currentTimeMillis()+".png";
        File destination=new File(dest);
        FileUtils.copyFile(source,destination);
        return dest;
    }


    public static void applyfileters(WebDriver driver) throws InterruptedException, IOException, ParseException {
        WebElement forEl = driver.findElement(By.xpath("//*[@class=\"SearchFilters_filters\"]/span[3]/div"));
        forEl.click();forEl.findElement(By.xpath("//li[6]")).click();
//        driver.findElement(By.xpath("//label[@id='downshift-6-label']")).click();
//        driver.findElement(By.xpath("//button[normalize-space()='Custom range']")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//span[@aria-label='Previous Month']")).click();
        driver.findElement(By.xpath("//span[@aria-label='Previous Month']")).click();
        driver.findElement(By.xpath("//div[@aria-label='Sun Jan 01 2023']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();
    }
    public static void search(WebDriver driver) throws InterruptedException, IOException, ParseException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));
        ele.sendKeys("linux");
        ele.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
    }


}
