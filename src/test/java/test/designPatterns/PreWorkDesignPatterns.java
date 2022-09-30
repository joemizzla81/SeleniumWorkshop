package test.designPatterns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreWorkDesignPatterns {

    private WebDriver driver;

    @BeforeEach
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/login");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    public void tearDown() {

        driver.quit();

    }

    @Test
    @DisplayName("User with login credentials")
    public void validLogin() {

        //Arrange
        String expectedText = "You logged into a secure area!";

        //Act
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("#login > button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement infoPanel = driver.findElement(By.cssSelector(("#flash")));
        String actualText = infoPanel.getText();

        //Assert
        assertThat(actualText, containsString(expectedText));

    }

    @Test
    @DisplayName("User with invalid username")
    public void invalidUsername() {

        //Arrange
        String expectedText = "Your username is invalid!";

        //Act
        driver.findElement(By.id("username")).sendKeys("InvalidUN");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("#login > button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement infoPanel = driver.findElement(By.cssSelector(("#flash")));
        String actualText = infoPanel.getText();

        //Assert
        assertThat(actualText, containsString(expectedText));

    }

    @Test
    @DisplayName("User with invalid password")
    public void invalidPassword() {

        //Arrange
        String expectedText = "Your password is invalid!";

        //Act
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("InvalidPW!");
        driver.findElement(By.cssSelector("#login > button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement infoPanel = driver.findElement(By.cssSelector(("#flash")));
        String actualText = infoPanel.getText();

        //Assert
        assertThat(actualText, containsString(expectedText));

    }

    @Test
    @DisplayName("User with long invalid username")
    public void invalidLongUsername() {

        //Arrange
        String expectedText = "Your username is invalid!";

        //Act
        driver.findElement(By.id("username")).sendKeys("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("#login > button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement infoPanel = driver.findElement(By.cssSelector(("#flash")));
        String actualText = infoPanel.getText();

        //Assert
        assertThat(actualText, containsString(expectedText));

    }

    @Test
    @DisplayName("User with long invalid password")
    public void invalidLongPassword() {

        //Arrange
        String expectedText = "Your password is invalid!";

        //Act
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567");
        driver.findElement(By.cssSelector("#login > button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement infoPanel = driver.findElement(By.cssSelector(("#flash")));
        String actualText = infoPanel.getText();

        //Assert
        assertThat(actualText, containsString(expectedText));

    }


}
