import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckIfElementExistsTest {

    WebDriver driver;
    @Test
    public void elementExistTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        // isEnabled() metoda do sprawdzenia czy element jest dostepny do interakcji
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());

        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        System.out.println(driver.findElement(By.cssSelector("[type='checkbox']")).isSelected());
    }

    @Test
    public void imageLoadTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/image.html");

        WebElement element = driver.findElement(By.id("smileImage"));
        String height1 = element.getAttribute("naturalHeight");

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        WebElement element2 = driver.findElement(By.id("smileImage"));
        String height2 = element2.getAttribute("naturalHeight");

        //Assert.assertEquals(height2, "223");
        Assert.assertEquals(height1, "223");

    }

    public boolean elementExist(By locator){
        try {
            driver.findElement(locator);
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
