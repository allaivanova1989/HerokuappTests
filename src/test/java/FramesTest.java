import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FramesTest extends BaseTest {
    @Test
    public void frame() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//li/a[@href='/iframe']")).click();
        WebDriver frame = driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        String textFromFrame = frame.findElement(By.xpath("//body[@id='tinymce']/p")).getText();
        assertEquals(textFromFrame, "Your content goes here.", "The text doesn't match");
    }

}
