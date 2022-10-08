package test.desinPatternsPracticeTask1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public void type(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public void selectOption(By by,String option){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(option);
    }

    public String getText(By by){
        return driver.findElement(by).getText();
    }

}
