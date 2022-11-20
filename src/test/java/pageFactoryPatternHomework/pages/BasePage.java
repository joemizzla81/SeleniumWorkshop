package pageFactoryPatternHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    private WebDriver driver;
    private String url;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        PageFactory.initElements(driver, this);
    }

    public void setURL(String newURL) {
        this.url = newURL;
    }

    public void open() {
        driver.get(url);
    }

    public String currentURL() {
        return this.driver.getCurrentUrl();
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text){
        element.sendKeys(text);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void hover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void selectOption(WebElement element,String option){
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

}
