import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.apache.commons.io.FileUtils.cleanDirectory;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {
    @Test

    public void seleniumDownloadFile() throws InterruptedException, IOException {
        String pathToDownload = System.getProperty("user.dir") + "src\\test\\downloads";
        String nameDownloadedFile = "sample.pdf";
        int wait = 15000;

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", pathToDownload);

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://the-internet.herokuapp.com/download");
        WebElement ourFile = driver.findElement(By.xpath("//div[@class=\"example\"]/a[@href=\"download/sample.pdf\"]"));

        FileUtils.cleanDirectory(new File(pathToDownload));
        File folder;
        folder = new File(pathToDownload);
        File[] listOfFiles = folder.listFiles();
        ourFile.click();
        boolean fileIsNotReady = true;

        while (wait != 0 && fileIsNotReady ) {
            listOfFiles = folder.listFiles();
            Thread.sleep(100);
            wait -= 100;
            if (listOfFiles.length != 0 && listOfFiles[0].getName().equals(nameDownloadedFile)) {
                fileIsNotReady = false;
            }
        }
        assertEquals(listOfFiles[0].getName(), nameDownloadedFile, "Downloaded document is not found");
        driver.quit();
    }
}
