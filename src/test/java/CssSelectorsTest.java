import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("Tekst");

        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        // zwrocenie wszystkich tagow na stronie
        By all = By.cssSelector("*");
        driver.findElements(all);

        By ulInDiv = By.cssSelector("div ul");
        By trInTable = By.cssSelector("table tr");
        By trInbody = By.cssSelector("tbody tr");
        driver.findElement(trInTable);
        driver.findElement(ulInDiv);
        driver.findElement(trInbody);

        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firstFormAfterLabel);
        driver.findElements(allFormsAfterLabel);

        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("[name*='name']");
        By attrStarts = By.cssSelector("[name^='f']");
        By attrEnds = By.cssSelector("[name$='ame']");
        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By nthChild = By.cssSelector("li:nth-child(4)");
        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(nthChild);
    }
}
