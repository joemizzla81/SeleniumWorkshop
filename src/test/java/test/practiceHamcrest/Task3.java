package test.practiceHamcrest;

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
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3 {

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

        //Act
        driver.findElement(By.id("ez-accept-all")).click();

        List<WebElement> companyColumn = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[1]"));
        int rows_count = companyColumn.size();

        List<String> actualCompanyNames = new ArrayList<>();
        for (WebElement companyName :companyColumn){
            actualCompanyNames.add(companyName.getText());
        }


        //Assert
        assertThat(rows_count, is(equalTo(expectedRowCount)));
        assertThat(actualCompanyNames, contains("Google", "Meta", "Microsoft", "Island Trading", "Adobe", "Amazon"));


    }
}
