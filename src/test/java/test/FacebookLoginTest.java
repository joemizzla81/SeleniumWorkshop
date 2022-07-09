package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacebookLoginTest {

    private WebDriver driver;


    @BeforeEach
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://www.facebook.com/");

    }

        @Test
        @DisplayName("Log in button should be available on the login page ")
        public void loginAvailableTest () {
            //Arrange -> Given

            String expectedResult = "Anmelden";

            // Act -> When


            WebElement loginButton = driver.findElement(By.cssSelector("[data-testid=royal_login_button]"));

            String actualResult = loginButton.getText();

            // Assert -> Then
            assertEquals(expectedResult, actualResult);

        }

        @Test
        @DisplayName("Email input field is available")
        public void emailAvailable () {
            //Arrange -> Given


            // Act -> When

            WebElement emailField = driver.findElement(By.cssSelector("[data-testid=royal_email]"));

            // Assert -> Then
            assertTrue(emailField.isDisplayed());

        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }

    }
