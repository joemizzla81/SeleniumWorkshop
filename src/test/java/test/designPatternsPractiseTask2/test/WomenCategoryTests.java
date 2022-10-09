package test.designPatternsPractiseTask2.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.designPatternsPractiseTask2.pages.WomenCategory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WomenCategoryTests {

    private WebDriver driver;

    private WomenCategory womenCategory;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        womenCategory = new WomenCategory(driver);

        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("Clicking on Tops category link leads to Tops page")
    public void topsCategoryLink(){

        //Arrange
        String expectedText = "TOPS";

        //Act
        womenCategory.clickTopsCategoryLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Assert
        assertThat(womenCategory.getCategoryName(), containsString(expectedText));
    }

    @Test
    @DisplayName("Clicking on Dresses category link leads to Dresses page")
    public void dressesCategoryLink(){

        //Arrange
        String expectedText = "DRESSES";

        //Act
        womenCategory.clickDressesCategoryLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Assert
        assertThat(womenCategory.getCategoryName(), containsString(expectedText));
    }

    @Test
    @DisplayName("Clicking on the Tops Checkbox activates Tops Filter")
    public void topsFilterCheckbox(){

        //Arrange
        String expectedText = "Categories: Tops";

        //Act
        womenCategory.clickTopsCatalogCheckbox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Assert
        assertThat(womenCategory.getNameOfCategoryFilter(), containsString(expectedText));
    }

    @Test
    @DisplayName("Clicking on the Dresses Checkbox activates Dresses Filter")
    public void dressesFilterCheckbox(){

        //Arrange
        String expectedText = "Categories: Dresses";

        //Act
        womenCategory.clickDressesCatalogCheckbox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Assert
        assertThat(womenCategory.getNameOfCategoryFilter(), containsString(expectedText));
    }

    @Test
    @DisplayName("Clicking Tops subcategories link leads to Tops page")
    public void topsSubCategoryLink(){

        //Arrange
        String expectedText = "TOPS";

        //Act
        womenCategory.clickTopsSubcategoryLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Assert
        assertThat(womenCategory.getCategoryName(), containsString(expectedText));
    }

    @Test
    @DisplayName("Clicking Dresses subcategories link leads to Dresses page")
    public void dressesSubCategoryLink(){

        //Arrange
        String expectedText = "DRESSES";

        //Act
        womenCategory.clickDressesSubcategoryLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Assert
        assertThat(womenCategory.getCategoryName(), containsString(expectedText));
    }

    @Test
    @DisplayName("Expanding Tops category list includes T-Shirt items")
    public void topsSubItems(){

        //Arrange
        String expectedText = "T-shirts";

        //Act
        womenCategory.clickTopsExpandBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Assert
        assertThat(womenCategory.getTopsFirstSubcategoryList(), containsString(expectedText));
    }

    @Test
    @DisplayName("Expanding Dresses category list includes Casual Dresses items")
    public void dressesSubItems(){

        //Arrange
        String expectedText = "Casual Dresses";

        //Act
        womenCategory.clickDressesExpandBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Assert
        assertThat(womenCategory.getDressesFirstSubcategoryListItem(), containsString(expectedText));
    }
}
