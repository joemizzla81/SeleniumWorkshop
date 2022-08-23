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

public class CssWorkShopHomeworkTask3Test {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.navigate().to("https://selectorshub.com/xpath-practice-page/");

    }

    @AfterEach
    public void tearDown(){

        driver.quit();

    }

    @Test
    @DisplayName("Insert strings into input fields")
    public void inputFieldsTest() throws InterruptedException {

        driver.findElement(By.cssSelector("#userId")).sendKeys("test1@test1.de");
        driver.findElement(By.cssSelector("#pass")).sendKeys("a passwoRD");

        driver.findElement(By.cssSelector("input[name='company']")).sendKeys("sample Company");

        driver.findElement(By.cssSelector("#inp_val")).sendKeys("first crush me");

        driver.findElement(By.cssSelector("#datepicker")).sendKeys("06.03.1987");

        String cssSelectorForHost1 = "#userName";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SearchContext shadow = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("#kils")).sendKeys("enter another name");

        SearchContext shadow1 = shadow.findElement(By.cssSelector("#app2")).getShadowRoot();
        Thread.sleep(1000);
        shadow1.findElement(By.cssSelector("#pizza")).sendKeys("pizza");





    }

}
