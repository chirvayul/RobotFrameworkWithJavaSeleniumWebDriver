import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import java.util.concurrent.TimeUnit;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 11.11.2016.
 */

@RobotKeywords
public class TC_1 {

    private WebDriver driver;

    private void startWebDriver() throws InterruptedException {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Locators.baseUrl);
    }

    @RobotKeyword
    @ArgumentNames({"login","password"})
    public void SignIn(String login, String password) throws InterruptedException {
        startWebDriver();
        Authorization Auth = PageFactory.initElements(driver, Authorization.class);
        Auth.SingIn(login, password);
        driver.quit();
    }

    @RobotKeyword
    @ArgumentNames({"networkName","login","password"})
    public void SignIn(String networkName, String login, String password) throws InterruptedException {
        startWebDriver();
        Authorization Auth = PageFactory.initElements(driver, Authorization.class);
        Auth.SingIn(networkName, login, password);
        driver.quit();
    }

    @RobotKeyword
    @ArgumentNames({"productUrl"})
    public void GetProductDetails(String productUrl) throws InterruptedException {
        startWebDriver();
        Products products = PageFactory.initElements(driver, Products.class);
        products.GetProductDetails(productUrl);
        driver.quit();
    }
}
