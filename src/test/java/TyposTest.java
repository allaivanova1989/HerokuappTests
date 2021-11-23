import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TyposTest extends BaseTest {
    @Test
    public void typoCheck() {
        driver.get("https://the-internet.herokuapp.com/typos");
        WebElement inputField = driver.findElement(By.tagName("p"));
        String text = inputField.getText();
        driver.get("https://advego.com/text/");
        driver.findElement(By.name("id_lang")).click();
        driver.findElement(By.cssSelector("[value='en']")).click();
        WebElement fieldCheck = driver.findElement(By.id("job_text_spell"));
        fieldCheck.sendKeys(text);
        WebElement buttonCheck = driver.findElement(By.cssSelector("[onclick='text_spell_check(); return false;']"));
        buttonCheck.click();
        WebElement checkMessage = driver.findElement(By.tagName("b"));
        System.out.println("The number of errors is " + checkMessage.getAttribute("text"));


    }
}
