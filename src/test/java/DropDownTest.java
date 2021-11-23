import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DropDownTest extends BaseTest {
    @Test
    public void dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.cssSelector("[value='1']")).click();
        assertEquals(driver.findElement(By.id("dropdown")).getAttribute("value"), "1", "We have a bug. Option 1 is not selected.");

        driver.findElement(By.cssSelector("[value='2']")).click();
        assertEquals(driver.findElement(By.id("dropdown")).getAttribute("value"), "2", "We have a bug. Option 2 is not selected.");

    }
}

