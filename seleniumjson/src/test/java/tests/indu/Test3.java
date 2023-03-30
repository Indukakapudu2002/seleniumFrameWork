package tests.indu;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.IOException;

import static utility.UtilityMethods.*;

public class Test3 extends TestBase {
    @Test
    public void searchValidation() throws Exception {
        search(driver);
        String s = driver.findElement(By.xpath(jsonfile(file2, "story"))).getText();
        if (s.contains("linux")) {
            link_test.pass("valid search");
        } else {
            link_test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
        }
    }
}


