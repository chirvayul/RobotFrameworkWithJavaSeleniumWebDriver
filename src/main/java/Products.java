import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 12.11.2016.
 */
public class Products {

    @FindBy (xpath = "//h1[contains(@itemprop,'name')]")
    private WebElement ItemName;
    
    @FindBy (id = "price_label")
    private WebElement ItemPrice;

    protected WebDriver driver;

    public Products (WebDriver driver) {
        this.driver = driver;
    }

    public void GetProductDetails(String ProductUrl){
        driver.get(ProductUrl);
        System.out.println("Название товара: " + ItemName.getText());
        System.out.println("Цена товара: " + ItemPrice.getText());
    }

}
