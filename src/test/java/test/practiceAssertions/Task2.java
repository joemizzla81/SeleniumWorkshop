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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

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
    @DisplayName("Assert values in company column")
    public void companyValuesTest(){

        //Arrange
        driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int expectedRowCount = 6;
        List<String> expectedCompanyNames = new ArrayList<>();
        expectedCompanyNames.add("Google");
        expectedCompanyNames.add("Meta");
        expectedCompanyNames.add("Microsoft");
        expectedCompanyNames.add("Island Trading");
        expectedCompanyNames.add("Adobe");
        expectedCompanyNames.add("Amazon");

        //Act
        driver.findElement(By.id("ez-accept-all")).click();

        List<WebElement> companyColumn = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[1]"));
        int rows_count = companyColumn.size();
        System.out.println("No of companyColumn rows are : " + rows_count);

        List<String> actualCompanyNames = new ArrayList<>();
        for (WebElement companyName :companyColumn){
            actualCompanyNames.add(companyName.getText());
        }

        System.out.println(actualCompanyNames);


        //Assert
        assertEquals(expectedRowCount,rows_count);
        assertEquals(expectedCompanyNames, actualCompanyNames);

    }


}
