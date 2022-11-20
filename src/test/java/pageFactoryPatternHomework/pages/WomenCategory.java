package pageFactoryPatternHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenCategory extends BasePage {

    private WebDriver driver;

    @FindBy(css = ".cat-name" )
    private WebElement categoryName;

    @FindBy(css = "#center_column > ul > li:nth-child(1) > div" )
    private WebElement firstProductContainer;

    @FindBy(xpath = "//a[@data-id-product='1']/child::span")
    private WebElement addToCartBtnFirstContainer;

    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;

    public WomenCategory(WebDriver driver, String url) {
        super(driver, url);
        this.driver = driver;
    }


    public String getCategoryName() {
        return getText(categoryName);
    }

    public void hoverOverFirstProductContainer() {
        hover(firstProductContainer);
    }

    public void clickAddToCartBtn() {
        click(addToCartBtnFirstContainer);
    }


    public void clickCheckoutBtn() {
        click(proceedToCheckoutBtn);
    }
}


