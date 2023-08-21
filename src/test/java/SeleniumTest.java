import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("ede");
        driver.get("https://www.google.pl/?hl=pl");
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
