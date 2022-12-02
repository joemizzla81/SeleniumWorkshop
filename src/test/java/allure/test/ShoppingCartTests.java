package allure.test;

import allure.facades.ShoppingCartFacade;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ShoppingCartTests {

    private WebDriver driver;

    @BeforeAll
    static void globalSetup(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void testSetup(){


        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterEach
    public void testTearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("First product added to cart and product title is correct")
    public void firstProductAvailableInCart(){

        //Arrange

        String expectedProductName = "Faded Short Sleeve T-shirts";
        ShoppingCartFacade facade = new ShoppingCartFacade(driver);

        //Act
        String actualProductName = facade.putFirstItemInCart();


        //Assert

        assertThat(actualProductName, containsString(expectedProductName));

    }

}
