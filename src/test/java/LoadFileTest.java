import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoadFileTest {

    @Test
    public void load() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Pobieramy aktualną datę i czas
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date currentDate = new Date();
        String timestamp = dateFormat.format(currentDate);

        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(before, new File("resources/beforeUpload" + timestamp + ".png"));

        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\M\\IdeaProjects\\TestAutomationProject1\\testowy.txt");
        File after = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(after, new File("resources/afterUpload"  + timestamp + ".png"));
    }
}
