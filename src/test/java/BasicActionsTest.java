import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.example.*;

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
        username.sendKeys(Keys.TAB);

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
    }
}
