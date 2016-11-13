package PersonalAccount;

import org.openqa.selenium.WebDriver;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 13.11.2016.
 */
public class PersonalAccount {

    protected WebDriver driver;

    public PersonalAccount (WebDriver driver) {
        this.driver = driver;
    }

    public void goToPersonalAccount(){
        driver.get("https://my.rozetka.com.ua");
    }
}
