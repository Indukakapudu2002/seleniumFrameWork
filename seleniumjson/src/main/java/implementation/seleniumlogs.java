package implementation;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.io.*;
import java.util.List;
import static utility.UtilityMethods.*;
public class seleniumlogs {
    public static Logger logger = Logger.getLogger(seleniumlogs.class);

    public static void main(String[] args) throws Exception{
        WebDriver driver = driverimplementation();
        logger.info("implementation");
        implementation(driver);
    }

    public static void implementation(WebDriver driver) throws Exception{
         String file1="/Users/kinduvadana/Desktop/credentials.json";
         String file2="/Users/kinduvadana/Desktop/webelements.json";
        getwebpage(driver);
        if (flag == true) {
            driver.findElement(By.xpath(jsonfile(file2,"login"))).click();
            logger.info("entering username and password");
            String name =jsonfile(file1,"username");
            System.out.println(name);
            String pwd =jsonfile(file1,"password");
            logger.info("send username and password");
            if (name.length() == 0 || pwd.length() == 0) {
                logger.error("Name and password should not be empty");
            }
            driver.findElement(By.xpath(jsonfile(file2,"userfield"))).sendKeys(name);
            driver.findElement(By.xpath(jsonfile(file2,"passwordfield" ))).sendKeys(pwd);
            Thread.sleep(3000);
            logger.info("loging");
            driver.findElement(By.xpath(jsonfile(file2,"button"))).click();
            logger.info("login successful");
            search(driver);
            logger.info("search succesfully");
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
            if (l.size() == 50) {
            } else {
                logger.error("enter the number of titles correctly");
            }
            logger.info("succesfully loaded 50 titles");

            applyfileters(driver);
            logger.info("applied fileters successfully");
            Thread.sleep(3000);
        } else {
            logger.info("invalid page");
            System.out.println("This page is not valid");
        }
        driver.quit();
    }

}
