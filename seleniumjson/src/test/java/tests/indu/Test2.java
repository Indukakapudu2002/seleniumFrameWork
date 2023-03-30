package tests.indu;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.IOException;

import static implementation.seleniumlogs.logger;
import static utility.UtilityMethods.getScreenshot;
import static utility.UtilityMethods.jsonfile;

public class Test2 extends TestBase {

    @Test(priority = 1)
    public void loginValidation() throws Exception {

        driver.findElement(By.xpath(jsonfile(file2,"login"))).click();
        String loginText = driver.findElement(By.xpath("//b[normalize-space()='Login']")).getText();
        if (loginText.equals("Login")) {
            link_test.pass("loginpage validated successfully");
        } else {
            link_test.fail("invalid loginpage");
        }
        entercredentials();
    }

    @Test(priority = 2)
    public void afterLogin() throws Exception{
        if (driver.findElement(By.xpath(jsonfile(file2,"logout"))).isDisplayed()) {
            link_test.pass("login successfully");
        } else {
            link_test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
        }

    }

    public void entercredentials() throws Exception{
        logger.info("entering username and password");
        String name = jsonfile(file1,"username");
        System.out.println(name);
        String pwd = jsonfile(file1,"password");
        logger.info("send username and password");
        if (name.length() == 0 || pwd.length() == 0) {
            link_test.pass("Name and password should not be empty");
        }
        driver.findElement(By.xpath(jsonfile(file2,"userfield"))).sendKeys(name);
        driver.findElement(By.xpath(jsonfile(file2,"passwordfield" ))).sendKeys(pwd);
        Thread.sleep(3000);
        logger.info("loging");
        driver.findElement(By.xpath(jsonfile(file2,"button"))).click();
        logger.info("login successful");
    }
}


