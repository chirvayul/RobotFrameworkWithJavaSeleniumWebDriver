import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 13.11.2016.
 */

public class WebDriverInitialization {

    protected static WebDriver driver;

    public WebDriver getWebDriver() {
        if (driver == null) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(Locators.baseUrl);
        }
        return driver;
    }

}
