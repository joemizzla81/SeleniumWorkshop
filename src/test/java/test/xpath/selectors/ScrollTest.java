package test.xpath.selectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScrollTest {

    private static WebDriver DRIVER;

    @BeforeAll
    static void globalSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void testSetup() {
        DRIVER = new ChromeDriver();
    }

    @AfterEach
    void testTeardown() {
        if (Objects.nonNull(DRIVER)) {
            DRIVER.quit();
        }
    }

    @Test
    @DisplayName("Check that dynamic content is rendered")
    void scrollDownYoutube() {
        // Arrange
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(15));
        By videoRowsSelector = By.cssSelector("#contents.style-scope.ytd-rich-grid-renderer>ytd-rich-grid-row");
        JavascriptExecutor jse = (JavascriptExecutor) DRIVER;

        // Act
        // Go to the YouTube web app
        DRIVER.get("https://www.youtube.com/");
        // Get number of video rows before scrolling
        int videoRowsSizeBeforeScroll = DRIVER.findElements(videoRowsSelector).size();
        // Scrolling
        jse.executeScript("window.scrollBy(0,20000)");
        // Wait for the expected behavior to occur(at most 15 seconds)
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(videoRowsSelector, videoRowsSizeBeforeScroll));
        // Get number of video rows after scrolling
        int elementSizeAfterScroll = DRIVER.findElements(videoRowsSelector).size();

        // Assert that the number of video rows after the scrolling is greater than the number before
        assertTrue(elementSizeAfterScroll > videoRowsSizeBeforeScroll);
    }

}
