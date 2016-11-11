import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.annotations.AfterClass;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 11.11.2016.
 */

@RobotKeywords
public class TC_1 {

    private WebDriver driver;

    @AfterClass
    public void tearDown() throws Exception {
        driver.close();
    }

    @RobotKeyword
    public void SignIn() throws InterruptedException {
        Authorization Auth = PageFactory.initElements(driver, Authorization.class);
        Auth.SingIn("kizkoyuliya@ukr.net", "2c35aba5");
    }
}
