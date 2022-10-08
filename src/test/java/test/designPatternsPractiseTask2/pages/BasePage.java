package test.designPatternsPractiseTask2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public String getText(By by){
        return driver.findElement(by).getText();
    }

}
