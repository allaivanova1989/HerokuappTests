import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DynamicControleTest extends BaseTest {
     String checkbox = "//div[@id=\"checkbox\"]/input";
    @Test
    public void dynamicControle() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@autocomplete='off']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id=\"checkbox-example\"]/p")));

        assertTrue(driver.findElements(By.xpath(checkbox)).isEmpty());

        WebElement input = driver.findElement(By.xpath("//form[@id=\"input-example\"]/input"));

        assertFalse(input.isEnabled(), "Input is enabled");

        driver.findElement(By.xpath("//form[@id=\"input-example\"]/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id=\"input-example\"]/p")));

        assertTrue(input.isEnabled(), "Input is disabled.");

    }
}
