import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverSettings {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://wrike.com/");
    }

    @After
    public void close() {

    }
}
