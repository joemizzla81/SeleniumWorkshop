package test.designPatternsPractiseTask2.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.designPatternsPractiseTask2.pages.ShoppingCart;
import test.designPatternsPractiseTask2.pages.WomenCategory;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class ShoppingCartTests {

    private WebDriver driver;

    private WomenCategory womenCategory;

    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        womenCategory = new WomenCategory(driver);

        shoppingCart = new ShoppingCart(driver);

        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("First product added to cart and title and unit price are correct")
    public void firstProductAvailableInCart(){

        //Arrange
        String expectedPageTitle = "SHOPPING-CART SUMMARY";
        String expectedProductName = "Faded Short Sleeve T-shirts";
        String expectedPrice = "$16.51";

        //Act
        womenCategory.hoverOverFirstProductContainer();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        womenCategory.clickAddToCartBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        womenCategory.clickCheckoutBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Assert
        assertThat(shoppingCart.getShoppingCartPageTitle(), containsString(expectedPageTitle));
        assertThat(shoppingCart.getNameOfFirstCartItem(), containsString(expectedProductName));
        assertThat(shoppingCart.getPriceOfFirstCartItem(), containsString(expectedPrice));
    }

}
