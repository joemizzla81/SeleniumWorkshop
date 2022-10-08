package test.designPatterns.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.designPatterns.pages.Login;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;
    private Login login;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        login = new Login(driver);

        driver.get("https://the-internet.herokuapp.com/login");

    }

    @Test
    public void validLoginTest(){

        login.with("tomsmith", "SuperSecretPassword!");

        assertThat(login.getSuccessMessage(), containsString("You logged into a secure area!"));
    }


}
