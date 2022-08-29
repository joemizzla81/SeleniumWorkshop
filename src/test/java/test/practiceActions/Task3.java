package test.practiceActions;

import io.github.bonigarcia.wdm.WebDriverManager;
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

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class Task3 {

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
    @DisplayName("Right-click test")
    public void rightClickTest(){

        //Arrange

        driver.navigate().to("https://example.cypress.io/commands/actions");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions act = new Actions(driver);
        String expectedText = "Right click to edit";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Act

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 2200)");
        WebElement rightClickField = driver.findElement(By.xpath("//div[@class='rightclick-action-div']"));
        wait.until(ExpectedConditions.elementToBeClickable(rightClickField));
        act.contextClick(rightClickField).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualText = driver.findElement(By.xpath("//input[@value='Right click to edit']")).getAttribute("value");

        //Assert

        assertEquals(expectedText, actualText);

    }
}
