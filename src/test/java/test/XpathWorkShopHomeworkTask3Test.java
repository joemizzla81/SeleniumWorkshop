package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class XpathWorkShopHomeworkTask3Test {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");

    }


    @AfterEach
    public void tearDown() throws InterruptedException {

        if (Objects.nonNull(driver)) {
           driver.quit();

        }
    }



        @Test
        @DisplayName("Insert strings into input fields")
        public void inputFieldsTest () throws InterruptedException {

            driver.findElement(By.xpath("//input[@id='userId']")).sendKeys("test1@test1.de");
            driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("a passwoRD");

            driver.findElement(By.xpath("//div[@class='userform']//input[@name='company']")).sendKeys("sample Company");

            driver.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("first crush me");


            driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06.03.1987");

        }


}
