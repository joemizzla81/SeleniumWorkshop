package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Click {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("http://demowebshop.tricentis.com");

    }


    @AfterEach
    public void tearDown() throws InterruptedException {

        if (Objects.nonNull(driver)) {
            driver.quit();

        }
    }

    @Test
    @DisplayName("Click Test")
    public void clickTest (){

        //Arrange
        String expectedURL = "http://demowebshop.tricentis.com/25-virtual-gift-card";

        //Act
        driver.findElement(By.xpath("//a[contains(text(),'$25 Virtual Gift Card')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Assert

        String actualURL = driver.getCurrentUrl();

        assertEquals(expectedURL, actualURL);



    }

}
