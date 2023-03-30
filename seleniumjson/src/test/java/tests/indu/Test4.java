package tests.indu;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.IOException;

import static utility.UtilityMethods.*;

public class Test4  extends TestBase {
    @Test
    public void applyFilterValidation() throws IOException, ParseException, InterruptedException {

        search(driver);
        applyfileters(driver);
        String s = driver.findElement(By.xpath("//label[@id='downshift-2-label']")).getText();
        System.out.println(s);
        if (s.contains("jan")) {
            link_test.pass("filters applied");
        } else {
            link_test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
        }
    }
}


