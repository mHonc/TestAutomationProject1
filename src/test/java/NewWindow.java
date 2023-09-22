import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindow {

    @Test
    public void windowTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.findElement(By.id("newPage")).click();
        //pobranie nazw okienek
        String currentWindow = driver.getWindowHandle();
        Set<String> windowNames = driver.getWindowHandles();
        for(String window : windowNames){
            if(!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }

        driver.findElement(By.id("L2AGLb")).click();
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("Selenium");
        q.sendKeys(Keys.ENTER);

        //powrot do pierwszego okna
        driver.switchTo().window(currentWindow);
        //driver.quit();
    }
}
