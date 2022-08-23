package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeiseTest {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.navigate().to("https://www.heise.de/");

    }

    @AfterEach
    public void tearDown(){

       // driver.quit();
    }

    @Test
    @DisplayName("Search for Corona articles")
    public void searchInputTest() throws InterruptedException {

        //Arrange


        //Act
        Thread.sleep(10000);
        driver.switchTo().frame("sp_message_iframe_639948");
        driver.findElement(By.cssSelector("button[title='Zustimmen']")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input[placeholder='Suchen mit Qwant'][name='q'][aria-label='Suchen mit Qwant'][role='textbox'][type='text']")).sendKeys("Corona");
        driver.findElement(By.xpath("//button[@aria-label='suchen']//*[name()='svg']")).click();

        //Assert
        assertTrue(driver.getCurrentUrl().contains("q=Corona"));


    }
}
