package test.practiceHamcrest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Task1andTask2 {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver  = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/notification_message_rendered");

        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("Notification message is displayed")
    public void notificationMessageIsDisplayed(){

        //Arrange


        //Act
        WebElement notificationMessageHeader = driver.findElement(By.cssSelector(".example > h3"));
        String actualText = notificationMessageHeader.getText();

        //Assert
        assertThat(actualText, containsString("Notification Message"));
    }


    @Test
    @DisplayName("Notification message is equal to expected text")
    public void notificationMessageEqualsText(){

        //Arrange
        String expectedText = "Notification Message";

        //Act
        WebElement notificationMessageHeader = driver.findElement(By.cssSelector(".example > h3"));
        String actualText = notificationMessageHeader.getText();

        //Assert
        assertThat(actualText, is(equalTo(expectedText)));
    }
}
