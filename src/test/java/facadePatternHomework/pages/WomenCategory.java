package facadePatternHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenCategory extends BasePage {

    private WebDriver driver;


    private final String LinkCategory_Xpath_Pattern = "//div[@class='block_content']//a[normalize-space()='{{Category_Name}}']";

    private final String Subcategory_Xpath_Pattern = "//div[@class='subcategory-image']//a[@title='{{Category_Name}}']";


    private final By categoryNameLocator = By.cssSelector(".cat-name");


    private final By firstProductContainerLocator = By.cssSelector("#center_column > ul > li:nth-child(1) > div");


    private final By addToCartBtnFirstContainer = By.xpath("//a[@data-id-product='1']/child::span");

    private final By proceedToCheckoutBtn = By.cssSelector("a[title='Proceed to checkout']");

    public WomenCategory(WebDriver driver, String url) {
        super(driver, url);
        this.driver = driver;
    }


    public void clickCategoryLink(String category) {
        By categorySelection = By.xpath(LinkCategory_Xpath_Pattern.replace("{{Category_Name}}", category));
        click(categorySelection);
    }

    public void clickSubCategoryLink(String category) {
        By subCategorySelection = By.xpath(Subcategory_Xpath_Pattern.replace("{{Category_Name}}", category));
        click(subCategorySelection);
    }


    public String getCategoryName() {
        return getText(categoryNameLocator);
    }

    public void hoverOverFirstProductContainer() {
        hover(firstProductContainerLocator);
    }

    public void clickAddToCartBtn() {
        click(addToCartBtnFirstContainer);
    }


    public void clickCheckoutBtn() {
        click(proceedToCheckoutBtn);
    }
}


