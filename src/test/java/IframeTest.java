import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {

    @Test
    public void iframeTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        //driver.switchTo().frame(0);
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("fname")).sendKeys("Michał");

        //wyjscie z iframe do strony glownej
        driver.switchTo().defaultContent();
    }
}
