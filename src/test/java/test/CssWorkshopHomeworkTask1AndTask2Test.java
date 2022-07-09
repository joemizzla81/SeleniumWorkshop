package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CssWorkshopHomeworkTask1AndTask2Test {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");

    }

    @Test
    @DisplayName("Task 1: Check Table 1 and assert string Google in row 2")
    public void table1GoogleStringTest(){

        // Arrange
        String expectedResult = "Google";

        //Act
        WebElement inputGoogle = driver.findElement(By.cssSelector("#customers > tbody > tr:nth-child(2) > td:nth-child(1)"));
        String actualResult = inputGoogle.getText();

        //Assert
        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Task 2: Check Table 2 and assert string Clock Tower Hotel in row 3")
    public void table2ClockTowerHotelStringTest(){

        // Arrange
        String expectedResult = "Clock Tower Hotel";

        //Act
        WebElement inputClockTowerHotel = driver.findElement(By.cssSelector(".tsc_table_s13 > tbody > tr:nth-child(2) > th"));
        String actualResult = inputClockTowerHotel.getText();

        //Assert
        assertEquals(expectedResult, actualResult);

    }





    @AfterEach
    public void tearDown(){

       driver.quit();
    }

}
