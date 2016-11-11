import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 10.11.2016.
 */
public class Authorization {

    protected WebDriver driver;

    public Authorization (WebDriver driver) {
        this.driver = driver;
    }

    public void SingIn(String login, String password) throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(@name,'signin')]")).click();

        WebElement Login = driver.findElement(By.xpath("//input[contains(@name,'login')]"));
        Login.click();
        Login.sendKeys(login);

        WebElement Pass = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
        Pass.click();
        Pass.sendKeys(password);

        WebElement SubmitButton = driver.findElement(By.xpath("//button[contains(@name,'auth_submit')]"));
        SubmitButton.click();

        //driver.close();
    }

}
