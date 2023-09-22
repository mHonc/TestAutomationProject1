import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ActionsTest {

    @Test
    public void clicksTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        //right click
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("bottom"))).perform();

        //double click
        actions.doubleClick(driver.findElement(By.id("bottom"))).perform();
    }

    @Test
    public void mouseOnElement() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        Actions actions = new Actions(driver);
        WebElement el = driver.findElement(By.tagName("h1"));
        actions.moveToElement(el).perform();
    }

    @Test
    public void pageTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    public void basicsPageTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.findElement(By.id("clickOnMe")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.name("fname")).sendKeys("Michał");

        System.out.println(driver.findElement(By.linkText("Visit W3Schools.com!")).getText());
        System.out.println(driver.findElement(By.linkText("IamWeirdLink")).getText());

        System.out.println(driver.findElement(By.tagName("table")).getText());

        Select cars = new Select(driver.findElement(By.tagName("Select")));
        cars.selectByValue("mercedes");
        List<WebElement> elements = cars.getOptions();
        for(WebElement el : elements){
            System.out.println(el.getText());
        }

        driver.findElement(By.cssSelector("[type='checkbox']")).click();

        driver.findElement(By.cssSelector("[value='male']")).click();

        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("Michal");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("123456789");

        driver.findElement(By.cssSelector("[value='Submit']")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        System.out.println(driver.findElement(By.id("smileImage")).isDisplayed());
        System.out.println(driver.findElement(By.className("topSecret")).isDisplayed());

        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windows = driver.getWindowHandles();
        for(String windowEl: windows){
            if(!windowEl.equals(mainWindow))
                driver.switchTo().window(windowEl);
        }
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
        driver.close();
        driver.switchTo().window(mainWindow);

        WebElement container = driver.findElement(By.id("container"));
        List<WebElement> containerElements = container.findElements(By.tagName("li"));
        System.out.println(containerElements.size());
    }
}
