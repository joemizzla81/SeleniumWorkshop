package test.xpath.selectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiffCssXpathSelectors {

    private WebDriver driver;

    @BeforeAll
    public static void globalSetup(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void driverSetup(){

        driver = new ChromeDriver();
    }

    @AfterEach
    public  void tearDown(){

        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("CSS: Log in button should be available on the login page ")
    public void loginCssAvailableTest () {
        //Arrange -> Given

        String expectedResult = "Anmelden";

        // Act -> When

        driver.navigate().to("https://www.facebook.com/");

        WebElement loginButton = driver.findElement(By.cssSelector("[data-testid=royal_login_button]"));

        String actualResult = loginButton.getText();

        // Assert -> Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Xpath: Log in button should be available on the login page ")
    public void loginXpathAvailableTest () {
        //Arrange -> Given

        String expectedResult = "Anmelden";

        // Act -> When

        driver.navigate().to("https://www.facebook.com/");

        WebElement loginButton = driver.findElement(By.xpath("//*[@data-testid='royal_login_button']"));

        String actualResult = loginButton.getText();

        // Assert -> Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("CSS: Der 2. div soll leer bleiben")
    void heiseCSSEmptyDivTest(){
        //Arrange
        String secondDivSelectorCSS ="html>body>div:nth-of-type(2)";

        // Act
        driver.navigate().to("https://heise.de");
        WebElement secondDiv = driver.findElement(By.cssSelector(secondDivSelectorCSS));
        String actualText = secondDiv.getText();

        //Assert
        assertTrue(actualText.isBlank());
    }

    @Test
    @DisplayName("Xpath: Der 2. div soll leer bleiben")
    void heiseXpathEmptyDivTest(){
        //Arrange
        String secondDivSelectorXpath ="/html/body/div[2]";

        // Act
        driver.navigate().to("https://heise.de");
        WebElement secondDiv = driver.findElement(By.xpath(secondDivSelectorXpath));
        String actualText = secondDiv.getText();

        //Assert
        assertTrue(actualText.isBlank());
    }
}
