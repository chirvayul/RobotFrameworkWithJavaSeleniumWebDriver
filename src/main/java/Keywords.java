import PersonalAccount.PersonalAccount;
import PersonalAccount.RecentlyViewed;
import ProductList.Products;
import org.openqa.selenium.support.PageFactory;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testng.Assert;

/**
 * PilotForRozetka
 * Created by Yuliya Chyrva on 11.11.2016.
 */

@RobotKeywords
public class Keywords extends WebDriverInitialization{

    @RobotKeyword
    @ArgumentNames({"networkName","login","password"})
    public void SignIn(String networkName, String login, String password) throws InterruptedException {
        Authorization Auth = PageFactory.initElements(getWebDriver(), Authorization.class);
        Auth.SingIn(networkName, login, password);
    }

    @RobotKeyword
    @ArgumentNames({"productUrl"})
    public void GetProductDetails(String productUrl) throws InterruptedException {
        Products products = PageFactory.initElements(getWebDriver(), Products.class);
        products.getProductDetails(productUrl);
    }

    @RobotKeyword
    public void RecentlyViewed() throws InterruptedException {
        RecentlyViewed recentlyViewed = PageFactory.initElements(getWebDriver(), RecentlyViewed.class);
        recentlyViewed.getRecentlyViewedProducts();
    }

    @RobotKeyword
    public void DeleteAllRecentlyViewed() throws InterruptedException {
        RecentlyViewed recentlyViewed = PageFactory.initElements(getWebDriver(), RecentlyViewed.class);
        recentlyViewed.deleteAllRecentlyViewedProducts();
    }

    @RobotKeyword
    public void GoToPersonalAccount() throws InterruptedException {
        PersonalAccount personalAccount = PageFactory.initElements(getWebDriver(), PersonalAccount.class);
        personalAccount.goToPersonalAccount();
    }

    @RobotKeyword
    @ArgumentNames({"productUrl"})
    public void Assertion(String productUrl) throws InterruptedException {
        Products products = PageFactory.initElements(getWebDriver(), Products.class);
        String productName = products.getProductDetails(productUrl).trim();
        GoToPersonalAccount();
        RecentlyViewed recentlyViewed = PageFactory.initElements(getWebDriver(), RecentlyViewed.class);
        for (String itemName: recentlyViewed.getRecentlyViewedProducts()) {
            if (productName.contains(itemName.trim())) {
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.fail("Просмотренный товар не отображается в списке всех просмотренных ранее товаров:  " + productName);
    }
}
