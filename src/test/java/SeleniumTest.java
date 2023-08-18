import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.pl/?hl=pl");

        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://www.google.pl/?hl=pl");
    }

}
