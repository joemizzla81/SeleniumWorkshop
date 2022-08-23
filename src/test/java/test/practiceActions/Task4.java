package test.practiceActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class Task4 {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");

        driver.manage().window().maximize();



    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("Delete button Test")
    public void deleteButtonTest(){

        //Arrange
        Actions act = new Actions(driver);
        String expectedText = "You entered: DELETE";


        //Act

        WebElement inputField = driver.findElement(By.id("target"));
        act.sendKeys(Keys.DELETE).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualText = driver.findElement(By.id("result")).getText();

        //Assert

        assertEquals(expectedText,actualText);

    }

    @Test
    @DisplayName("Enter button Test")
    public void EnterButtonTest(){

        //Arrange
        Actions act = new Actions(driver);
        String expectedText = "You entered: ENTER";


        //Act

        WebElement inputField = driver.findElement(By.id("target"));
        act.sendKeys(Keys.ENTER).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualText = driver.findElement(By.id("result")).getText();

        //Assert

        assertEquals(expectedText,actualText);

    }

    @Test
    @DisplayName("Space button Test")
    public void SpaceButtonTest(){

        //Arrange
        Actions act = new Actions(driver);
        String expectedText = "You entered: SPACE";


        //Act

        WebElement inputField = driver.findElement(By.id("target"));
        act.sendKeys(Keys.SPACE).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualText = driver.findElement(By.id("result")).getText();

        //Assert

        assertEquals(expectedText,actualText);

    }

    @Test
    @DisplayName("Key up button Test")
    public void KeyUpButtonTest(){

        //Arrange
        Actions act = new Actions(driver);
        String expectedText = "You entered: UP";


        //Act

        WebElement inputField = driver.findElement(By.id("target"));
        act.sendKeys(Keys.ARROW_UP).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualText = driver.findElement(By.id("result")).getText();

        //Assert

        assertEquals(expectedText,actualText);

    }

}
