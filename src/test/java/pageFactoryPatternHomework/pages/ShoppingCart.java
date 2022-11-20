package pageFactoryPatternHomework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShoppingCart extends BasePage {

    @FindBy(id="cart_title")
    private WebElement pageTitle;

    @FindBy(css="#product_1_1_0_0 > td.cart_description > p > a")
    private WebElement firstCartItemName;

    @FindBy(css="#product_price_1_1_0 > span")
    private WebElement firstCartItemUnitPrice;

    private WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getNameOfFirstCartItem(){
        return getText(firstCartItemName);
    }

}
