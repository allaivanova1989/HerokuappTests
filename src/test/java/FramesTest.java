import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesTest extends BaseTest{
    WebDriver frame= driver.switchTo().frame(driver.findElement(By.id("")));
}
