package test.xpath.selectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class XpathSelectors {

    private WebDriver driver;

    @BeforeAll
    public static void globalSetup(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void driverSetup(){

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    public  void tearDown(){

        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Alle <a> Tag muessen einen nicht leeren href haben")
    public void hrefAvailabe(){

        // Arrange
        String xpath ="//*[contains(text(), 'Jetzt bestellen')]";

        //Act
        driver.navigate().to("https://www.heise.de");

        

        List<WebElement> anchors = driver.findElements(By.xpath("xpath"));
        System.out.println("heise: " + anchors.size());
        boolean actualResult = true;

        for (WebElement element: anchors){
            System.out.println("### " + element.getTagName() + " ###");
            boolean hrefAvailable = ! element.getAttribute("href").isBlank();
            actualResult = actualResult && hrefAvailable;
        }

        // Assert
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Alle Produktbilder sind in einem <a> enthalten")
    public void wrappedInAnchorTest(){

        // Arrange
        String xpath ="//div[@class='product-grid home-page-product-grid']//img/..";

        //Act
        driver.navigate().to("http://demowebshop.tricentis.com/");



        List<WebElement> anchors = driver.findElements(By.xpath("xpath"));
        System.out.println("heise: " + anchors.size());
        boolean actualResult = true;

        for (WebElement element: anchors){
            System.out.println("### " + element.getTagName() + " ###");
            boolean anchorTagName = element.getTagName().equals("a");
            boolean hrefAvailable = ! element.getAttribute("href").isBlank();
            actualResult = actualResult && hrefAvailable && anchorTagName;
        }

        // Assert
        assertTrue(actualResult);
    }
}
