import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By fullPath = By.xpath("/html/body/img");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//img");
        driver.findElement(shortPath);

        // wyszukiwanie po id
        By buttonId = By.xpath("/html/body/button[@id='clickOnMe']");
        driver.findElement(buttonId);

        // wyszukiwanie po id drugi sposob
        By buttonId2 = By.xpath("//*[@id='clickOnMe']");
        driver.findElement(buttonId2);

        // wyszukiwanie po name
        WebElement fname = driver.findElement(By.xpath("//input[@name='fname']"));
        Assert.assertTrue(fname.isDisplayed());

        // wyszukiwanie po class
        WebElement hidden = driver.findElement(By.xpath("//p[@class='topSecret']"));
        Assert.assertTrue(hidden.isEnabled());

        // wyszukiwanie po input
        List<WebElement> inputs = (List<WebElement>) driver.findElements(By.xpath("//input"));
        System.out.println(inputs.size());

        // wyszukiwanie po linku
        WebElement link = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        Assert.assertTrue(link.isDisplayed());

        // wyszukiwanie po niepelnym linku
        WebElement partialLink = driver.findElement(By.xpath("//a[contains(text(),'Visit W3Schools')]"));
        Assert.assertTrue(partialLink.isDisplayed());

        // wszystkie el zawierajace id: $x("//*[@id]")
        By allXpath = By.xpath("//*[@id]");
        driver.findElements(allXpath);

        By secondEl = By.xpath("//input[2]");
        driver.findElement(secondEl);

        By lastEl = By.xpath("//input[last()]");
        driver.findElement(lastEl);

        By elWithAttr = By.xpath("//*[@fname]");
        driver.findElements(elWithAttr);

        By child = By.xpath("//div/child::ul");
        By desc = By.xpath("//div/descendant::ul");
        By parent = By.xpath("//div/../..");
        By asc = By.xpath("//div/ancestor::*");
        By foll = By.xpath("//img/following::*");
        By follSib = By.xpath("//img/following-sibling::*");
        By prec = By.xpath("//img/preceding::*");
        By precSib = By.xpath("//img/preceding-sibling::*");
        driver.findElement(child);
        driver.findElement(desc);
        driver.findElement(parent);
        driver.findElement(asc);
        driver.findElement(foll);
        driver.findElement(follSib);
        driver.findElement(prec);
        driver.findElement(precSib);

        By divsAndLinks = By.xpath("//a | //div");
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        By orOp = By.xpath("//input[@name='fname' or @id='fnam']");
        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);

        //find element wyrzuca wyjatek, find elements nie

        //priorytety selektorow:
        // id (najlepiej unikalne, nie generowane automatycznie
        // name
        // bylinktext, bypartiallinktext
        // jak nie ma zadnych z powyzszych, to css
        // xpath jest najwolniejszy, ale mozna zbudowac najbardziej skomplikowane selektory
    }

}
