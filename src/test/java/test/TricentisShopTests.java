package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TricentisShopTests {

    private WebDriver driver;


    @BeforeEach
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();


    }

    @Test
    @DisplayName("Email has wrong format ")
    public void emailFailureMessageTest(){

        driver.navigate().to("http://demowebshop.tricentis.com/register");
        String expectedResult = "Wrong email";

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("Alina");

        Awaitility.await().atMost(Duration.ofMillis(1000));
        driver.findElement(By.id("LastName")).sendKeys("avs");

        WebElement failureMessageContainer = driver.findElement(By.cssSelector(".field-validation-error[data-valmsg-for=Email] > span"));

        String actualResult = failureMessageContainer.getText();

        assertEquals(expectedResult, actualResult);


    }

    @AfterEach
    public void tearDown() {
       driver.quit();
    }

}
