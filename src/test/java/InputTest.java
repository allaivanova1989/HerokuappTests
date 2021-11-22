import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import java.util.Objects;

public class InputTest extends BaseTest {
    @Test
    public void inputDigits() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("12345688");

        inputField.sendKeys(Keys.ARROW_UP);
        assertEquals(inputField.getAttribute("value"), "12345689", " We have a bug with ARROW_UP");

        inputField.sendKeys(Keys.ARROW_DOWN);
        assertEquals(inputField.getAttribute("value"), "12345688", " We have a bug with ARROW_Down.");
    }


    @Test
    public void inputLetters() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("sddhyt");
        assertEquals(inputField.getAttribute("text"), "", " We have a bug. The field must only support numeric input.");
    }

    @Test
    public void inputSimbols() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("+-");
        assertEquals(inputField.getAttribute("text"), "", " We have a bug. The field must only support numeric input.");
    }


}
