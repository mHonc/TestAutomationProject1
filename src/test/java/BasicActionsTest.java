import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {
    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        //driver.findElement(By.xpath("//a[text()='Podstawowa strona testowa']")).click();
        driver.findElement(By.linkText("Podstawowa strona testowa")).click();
        //driver.findElement(By.xpath("//*[@id="clickOnMe"]").click();
        driver.findElement(By.id("fname")).sendKeys("Michał");

        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("adminadmin");
        System.out.println(username.getAttribute("value"));
        username.sendKeys(Keys.ENTER);
        Alert fitstAlert = driver.switchTo().alert();
        fitstAlert.accept();
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        //driver.findElement(By.cssSelector("[value='mercedes']")).click();
        WebElement carSelect = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(carSelect);
        cars.selectByValue("mercedes");

        List<WebElement> options = cars.getOptions();
        for(WebElement element : options){
            System.out.println(element.getText());
        }

        SelectCheck check = new SelectCheck();
        System.out.println(check.searchForSelect("Volvo", driver.findElement(By.cssSelector("select"))));
        System.out.println(check.searchForSelect("volvo", driver.findElement(By.cssSelector("select"))));

        //wyszukiwanie ukrytego elementu dzieki textContent
        System.out.println(driver.findElement(By.cssSelector("[class='topSecret']")).getAttribute("textContent"));

    }
}
