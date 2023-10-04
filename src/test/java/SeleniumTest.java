import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("chrome");
        driver.get("https://www.google.pl/?hl=pl");
        driver.manage().window().maximize();
    }

    @Test
    public void openSeleniumDemoPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");
        driver.findElement(By.xpath("//span[text()='Shop']")).click();
        WebElement element1 = driver.findElement(By.xpath("//h2[text()='GIT basics']"));
        Assert.assertTrue(element1.isDisplayed());
        WebElement element2 = driver.findElement(By.xpath("//h2[text()='BDD Cucumber']"));
        Assert.assertTrue(element2.isDisplayed());
        //driver.quit();
    }

    public static WebDriver getDriver(String browser){
        try {
            if (browser.equals("chrome"))
                return new ChromeDriver();
            else if (browser.equals("firefox"))
                return new FirefoxDriver();
            else if (browser.equals("edge"))
                return new EdgeDriver();
            else
                throw new IllegalArgumentException("Illegal driver name");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ChromeDriver();
        }
    }

}
