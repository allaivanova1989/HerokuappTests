import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FileuploadTest extends BaseTest{
    @Test
    public void fileUpload (){
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("src/test/resources/ДЗ№5.doc");
        driver.findElement(By.id("file-submit")).click();
        assertEquals(driver.findElement(By.xpath("//div[@class='example']/h3")).getText(),
                "File uploaded","Файл не загрузился.");

    }
}
