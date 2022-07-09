package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlinaTests {

    private WebDriver driver;

    @BeforeAll
    static void globalDriverSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void driverSetup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        if (Objects.nonNull(driver)) {
           /* driver.quit();
            driver.close();*/
        }
    }

    @Test
    @DisplayName("Find 'Google' in the Demo Table 1")
    void googleTest() {
        // Arrange -> Given
        String expectedResult = "Google";

        // Act -> When
        driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");
        WebElement googleElement = driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)"));
        String actualResult = googleElement.getText();

        // Assert -> Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Find 'Clock Tower Hotel' in the Demo Table 2")
    void clockTowerTest() {
        // Arrange -> Given
        String expectedResult = "Clock Tower Hotel";

        // Act -> When
        driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");
        WebElement clockTowelElement = driver.findElement(By.cssSelector("tr:nth-child(2) > th"));
        String actualResult = clockTowelElement.getText();

        // Assert -> Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Type text in the input field")
    void inputTextTest() {
        // Arrange -> Given
        String inputText = "My text";

        // Act -> When
        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
        WebElement emailInputElement = driver.findElement(By.cssSelector("#userId"));
        emailInputElement.sendKeys(inputText);
    }
}


