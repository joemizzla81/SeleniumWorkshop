package test.designPatternsPractiseTask2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends BasePage{

    private WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By pageTitle = By.id("cart_title");

    By firstCartItemName = By.cssSelector("#product_1_1_0_0 > td.cart_description > p > a");

    By firstCartItemUnitPrice = By.cssSelector("#product_price_1_1_0 > span");

    public String getShoppingCartPageTitle(){
       return getText(pageTitle);
    }

    public String getNameOfFirstCartItem(){
        return getText(firstCartItemName);
    }

    public String getPriceOfFirstCartItem(){
        return getText(firstCartItemUnitPrice);
    }
}
