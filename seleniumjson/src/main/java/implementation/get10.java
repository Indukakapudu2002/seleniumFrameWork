package implementation;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utility.UtilityMethods.*;

public class get10 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://news.ycombinator.com/");
        search(driver);
        Thread.sleep(5000);
        List<WebElement> l = driver.findElements(By.xpath("//article[@class='Story']"));
        System.out.println(driver.findElement(By.xpath("//article[@class='Story']")));
//        for (int i = 0; i < 10; i++) {
//            System.out.println(l.get(i));
//        }
        driver.quit();


    }
}


