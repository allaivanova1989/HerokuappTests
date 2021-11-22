import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class AddRemoveElementsTest extends BaseTest {
    String deleteButtonLocator = "[oncLick='deleteElement()']";

    @Test
    public void addRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.cssSelector("[oncLick='addElement()']"));
        addButton.click();
        addButton.click();
        List<WebElement> deleteButton = driver.findElements(By.cssSelector(deleteButtonLocator));
        assertEquals(deleteButton.size(), 2, "Количество элементов не равно 2.");

        deleteButton.get(1).click();
        deleteButton = driver.findElements(By.cssSelector(deleteButtonLocator));
        assertEquals(deleteButton.size(), 1, "Количество элементов не равно 1.");


    }


}