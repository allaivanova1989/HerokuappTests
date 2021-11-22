import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTest extends BaseTest {
    @Test
    public void checkboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type = checkbox]"));
        assertFalse(checkboxes.get(0).isSelected(), "We have a bug. Checkbox 1 is selected.");
        checkboxes.get(0).click();
        assertTrue(checkboxes.get(0).isSelected(), "We have a bug. Checkbox 1 is not selected.");

        assertTrue(checkboxes.get(1).isSelected(), "We have a bug. Checkbox 2 is not selected.");
        checkboxes.get(1).click();
        assertFalse(checkboxes.get(1).isSelected(), "We have a bug. Checkbox 2 is selected.");

    }
}
