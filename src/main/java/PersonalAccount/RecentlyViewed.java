package PersonalAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 13.11.2016.
 */
public class RecentlyViewed {

    @FindBy(xpath = "//span[contains(text(),'Просмотренные')]")
    private WebElement recentlyViewed;

    @FindBy(xpath = "//a[contains(@name, 'delete_all')]")
    private WebElement deleteAllButton;

    protected WebDriver driver;

    public RecentlyViewed(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<String> getRecentlyViewedProducts() {
        recentlyViewed.click();
        List<WebElement> AllElements = driver.findElements(By.xpath("//div[contains(@class, 'clearfix g-i-tile')]"));
        ArrayList<String> ProductNames = new ArrayList<String>();
        for (WebElement element : AllElements) {
            WebElement label = element.findElement(By.xpath(".//a[contains(@class, 'g-title-link')]"));
            WebElement price = element.findElement(By.xpath(".//div[contains(@class, 'g-price-uah')]"));
            System.out.println(label.getText()+"   "+price.getText());
            ProductNames.add(label.getText());
        }
        return ProductNames;
    }

    public void deleteAllRecentlyViewedProducts() {
        deleteAllButton.click();
    }

}
