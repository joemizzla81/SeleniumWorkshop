package test.practiceActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Task2 {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

    }

    @AfterEach
    public void tearDown(){

        driver.quit();

    }

    @Test
    @DisplayName("Double click test")
    public void doubleClickTest(){

        //Arrange
        driver.navigate().to("https://example.cypress.io/commands/actions");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions act = new Actions(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String expectedText = "Double click to edit";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Act
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 2000)");
        WebElement doubleClickField = driver.findElement(By.cssSelector(".form-group > .action-div"));
        wait.until(ExpectedConditions.elementToBeClickable(doubleClickField));
        act.doubleClick(doubleClickField).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement inputFieldAfterDoubleClick = driver.findElement(By.cssSelector("#actions > div > div:nth-child(20) > div > form > div > input"));
        String actualText = inputFieldAfterDoubleClick.getAttribute("value");

        //Assert
        assertEquals(expectedText,actualText);

    }

}
