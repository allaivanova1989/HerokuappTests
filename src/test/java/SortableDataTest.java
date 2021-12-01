import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableDataTest extends BaseTest {

    @Test
    public void checkTheContentsOfSeveralTableCells(){

        driver.get("http://the-internet.herokuapp.com/tables");
        List<WebElement> webElementList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
        List<String> lastNameList = new ArrayList<>();
        lastNameList.add(webElementList.get(0).getText());
        lastNameList.add(webElementList.get(1).getText());
        lastNameList.add(webElementList.get(2).getText());
        lastNameList.add(webElementList.get(3).getText());
        Collections.sort(lastNameList);

        driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[1]/span")).click();

        List<WebElement> webElementSortedList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
        List<String> lastNameSortedList = new ArrayList<>();
        lastNameSortedList.add(webElementSortedList.get(0).getText());
        lastNameSortedList.add(webElementSortedList.get(1).getText());
        lastNameSortedList.add(webElementSortedList.get(2).getText());
        lastNameSortedList.add(webElementSortedList.get(3).getText());

        Assert.assertEquals(lastNameSortedList, lastNameList, "Arrays aren't sorted or arrays are sorted differently");

    }
}