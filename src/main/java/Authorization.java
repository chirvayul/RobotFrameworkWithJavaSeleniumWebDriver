import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 10.11.2016.
 */
public class Authorization {

    @FindBy (xpath = "//a[contains(@name,'signin')]")
    private WebElement Signin;

    @FindBy (xpath = "//input[contains(@name,'login')]|//input[contains(@name,'email')]")
    private WebElement Login;

    @FindBy (xpath = "//input[contains(@name,'password')]|//input[contains(@name,'pass')]")
    private WebElement Password;

    @FindBy (xpath = "//button[contains(@name,'auth_submit')]|//button[contains(@type,'submit')]")
    private WebElement SubmitButton;

    protected WebDriver driver;

    public Authorization (WebDriver driver) {
        this.driver = driver;
    }

    public void SingIn(String login, String password) throws InterruptedException {
        Signin.click();
        SubmitLoginForm(login, password);
    }

    public void SingIn(String networkName, String login, String password) throws InterruptedException {
        Signin.click();
        driver.findElement(By.xpath("//div[contains(@type, '"+networkName+"')]")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        itr.next();
        String childName = itr.next();
        driver.switchTo().window(childName);
        SubmitLoginForm(login, password);
    }

    private void SubmitLoginForm (String login, String password) throws InterruptedException {
        Login.sendKeys(login);
        Password.sendKeys(password);
        SubmitButton.click();
    }
}
