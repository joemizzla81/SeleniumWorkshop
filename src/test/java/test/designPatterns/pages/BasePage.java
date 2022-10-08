package test.designPatterns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void type(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    public void click (By by){
        driver.findElement(by).click();
    }

    public String getText(By by){
        return driver.findElement(by).getText();
    }
}
