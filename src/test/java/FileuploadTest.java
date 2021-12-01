import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.File;
import static org.testng.Assert.*;

public class FileuploadTest extends BaseTest {
    @Test
    public void fileUpload() {
        driver.get("http://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/MySQL.docx");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        assertEquals(driver.findElement(By.id("uploaded-files")).getText(),
                "MySQL.docx",
                "The file didn't load.");

    }
}
