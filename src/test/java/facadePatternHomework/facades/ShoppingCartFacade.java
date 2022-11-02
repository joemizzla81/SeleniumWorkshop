package facadePatternHomework.facades;

import facadePatternHomework.pages.ShoppingCart;
import facadePatternHomework.pages.WomenCategory;
import org.openqa.selenium.WebDriver;

public class ShoppingCartFacade {

    public String womenCategory_Page_Url = "http://automationpractice.com/index.php?id_category=3&controller=category";
    public WomenCategory womenCategory;
    public ShoppingCart shoppingCart;

    public ShoppingCartFacade(WebDriver driver) {

        womenCategory = new WomenCategory(driver, womenCategory_Page_Url);
        shoppingCart = new ShoppingCart(driver);
    }

    public String putFirstItemInCart(){

        womenCategory.open();
        womenCategory.hoverOverFirstProductContainer();
        womenCategory.clickAddToCartBtn();
        womenCategory.clickCheckoutBtn();

        return shoppingCart.getNameOfFirstCartItem();
    }
}
