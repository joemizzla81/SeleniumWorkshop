package test.practiceAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class Task1 {

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
    @DisplayName("Assert that the text “Notification Message” is displayed")
    public void notificationMessage(){

        //Arrange
        driver.navigate().to("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.manage().window().maximize();
        String expectedText = "Notification Message";

        //Act
        WebElement notificationMessageHeader = driver.findElement(By.cssSelector(".example > h3"));
        String actualText = notificationMessageHeader.getText();

        //Assert
        assertTrue(actualText.equals(expectedText));




    }
}
