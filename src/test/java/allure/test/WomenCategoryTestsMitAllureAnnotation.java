package allure.test;

import allure.facades.WomenCategoryFacadeMitAllure;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class WomenCategoryTestsMitAllureAnnotation {

    private WebDriver driver;

    @Epic("Web shop order") //Allure
    @Story("Women category") //Allure

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
    public void tearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("Clicking on Tops category link leads to Tops page")
    @Description("Das ist eine noch genauere Beschreibung für Allure") //Allure
    @Story("Story Beschreibung für topsCategoryLink") //Allure
    @Severity(SeverityLevel.BLOCKER)  //Allure
    public void topsCategoryLink(){

        //Arrange
        WomenCategoryFacadeMitAllure facade = new WomenCategoryFacadeMitAllure(driver);
        String expectedText = "TOPS";

        //Act
        String actualCategoryText = facade.chooseCategory("Tops");

        //Assert
        assertThat(actualCategoryText, containsString(expectedText));
    }


    @Test
    @DisplayName("Clicking on Dresses category link leads to Dresses page")
    public void dressesCategoryLink(){

        //Arrange
        WomenCategoryFacadeMitAllure facade = new WomenCategoryFacadeMitAllure(driver);
        String expectedText = "DRESSES";

        //Act
        String actualCategoryText = facade.chooseCategory("Dresses");


        //Assert
        assertThat(actualCategoryText, containsString(expectedText));
    }



    @Test
    @DisplayName("Clicking Tops subcategories link leads to Tops page")
    public void topsSubCategoryLink(){

        //Arrange
        WomenCategoryFacadeMitAllure facade = new WomenCategoryFacadeMitAllure(driver);
        String expectedText = "TOPS";

        //Act
        String actualSubcategoryText = facade.chooseSubCategory("Tops");


        //Assert
        assertThat(actualSubcategoryText, containsString(expectedText));
    }

    @Test
    @DisplayName("Clicking Dresses subcategories link leads to Dresses page")
    public void dressesSubCategoryLink(){

        //Arrange
        WomenCategoryFacadeMitAllure facade = new WomenCategoryFacadeMitAllure(driver);
        String expectedText = "DRESSES";

        //Act
        String actualSubcategoryText = facade.chooseSubCategory("Dresses");


        //Assert
        assertThat(actualSubcategoryText, containsString(expectedText));
    }

}
