package actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class Scroll {


    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();



    }


    @AfterEach
    public void tearDown() throws InterruptedException {

        if (Objects.nonNull(driver)) {
            driver.quit();

        }
    }

    @Test
    @DisplayName("Scroll Test")
    public void scrollTest () {

        //Arrange
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String cssSelector = "#contents.style-scope ytd-rich-grind-renderer > ytd-rich-grid-row";
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Act
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//ytd-button-renderer[2]//a[1]//tp-yt-paper-button[1]//yt-formatted-string[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        int elementSizeBeforeScroll = driver.findElements(By.cssSelector(cssSelector)).size();
        jse.executeScript("window.scrollBy(0, 10000)");

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contents']/ytd-rich-grid-row[15]")));


        int elementSizeAfterScroll = driver.findElements(By.cssSelector(cssSelector)).size();

        //Assert
        assertTrue(elementSizeAfterScroll > elementSizeBeforeScroll);

    }


}
