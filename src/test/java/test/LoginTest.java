package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.containsString;


public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void validloginTest(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.tagName("button")).click();

        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));

        assertThat(successMessage.getText(), containsString("You logged into a secure area!"));
    }

    @Test
    public void invalidUsernameTest(){
        driver.findElement(By.id("username")).sendKeys("invalid username");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.tagName("button")).click();

        WebElement errorMessage = driver.findElement(By.id("flash"));

        assertThat(errorMessage.getText(), containsString("Your username is invalid!"));

    }

    @Test
    public void invalidPasswordTest(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("invalid password");

        driver.findElement(By.tagName("button")).click();

        WebElement errorMessage = driver.findElement(By.id("flash"));

        assertThat(errorMessage.getText(), containsString("Your password is invalid!"));

    }

    @Test
    public void noUsernameTest(){
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorMessage = driver.findElement(By.id("flash"));

        assertThat(errorMessage.getText(), containsString("Your username is invalid!"));
    }

    @Test
    public void noPasswordTest(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorMessage = driver.findElement(By.id("flash"));

        assertThat(errorMessage.getText(), containsString("Your password is invalid!"));

    }

    @AfterEach
      public void tearDown(){
        driver.quit();
    }


}
