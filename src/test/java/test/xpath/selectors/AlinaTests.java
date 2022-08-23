package test.xpath.selectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AlinaTests {

    private WebDriver driver;

    @BeforeAll
    static void globalSetup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void driverSetup(){
        driver = new ChromeDriver();
    }
/*
   @AfterEach
   void teardown(){
       if(Objects.nonNull(driver)){
           driver.quit();
       }
   }
*/

    @Test
    @DisplayName("Alle Eingabefehler in Userform identifizieren und befuellen")
    void inputFieldsIdentification()  {
        //Arrange
        String xpath = "//div[@class='userform']//input[not(@type='submit')]";

        //Act
        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
        List<WebElement> allInputs = driver.findElements(By.xpath(xpath));
        for (WebElement element : allInputs){
            try{
                element.sendKeys("test text");
            } catch (ElementNotInteractableException ex){
                //ex.printStackTrace();
            }
            String result = element.getText();

            //Assert
            assertNotNull(result);
        }
    }

    @Test
    @DisplayName("Eingabe von Namen ueber Automation tool")
    void inputFieldNameTest()  {
        //Arrange
        String xpathActivate = "//*[local-name() = 'svg'][@iconid='editon']";
        String xpathInputField = "//input[@class='nameFld']";

        //Act
        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");

        WebElement activationBTN = driver.findElement(By.xpath(xpathActivate));
        activationBTN.click();
        WebElement inputNameField = driver.findElement(By.xpath(xpathInputField));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        inputNameField.sendKeys("Alina");

        String result = inputNameField.getText();

        //Assert
        assertNotNull(result);
    }


}
