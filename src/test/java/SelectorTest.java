import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // wyszukiwanie po id
        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        Assert.assertTrue(clickOnMeButton.isDisplayed());

        // wyszukiwanie po name
        WebElement fname = driver.findElement(By.name("fname"));
        Assert.assertTrue(fname.isDisplayed());

        // wyszukiwanie po class
        WebElement hidden = driver.findElement(By.className("topSecret"));
        Assert.assertTrue(hidden.isEnabled());

        // wyszukiwanie po input
        List<WebElement> inputs = (List<WebElement>) driver.findElements(By.tagName("input"));
        System.out.println(inputs.size());

        // wyszukiwanie po linku
        WebElement link = driver.findElement(By.linkText("Visit W3Schools.com!"));
        Assert.assertTrue(link.isDisplayed());

        // wyszukiwanie po niepelnym linku
        WebElement partialLink = driver.findElement(By.partialLinkText("Visit W3Schools."));
        Assert.assertTrue(partialLink.isDisplayed());
    }
}
