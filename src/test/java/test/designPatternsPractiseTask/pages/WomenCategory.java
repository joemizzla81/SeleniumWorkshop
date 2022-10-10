package test.designPatternsPractiseTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenCategory extends BasePage {

    private WebDriver driver;

    private final By topsCategoryLinkLocator = By.xpath("//div[@class='block_content']//a[normalize-space()='Tops']");
    private final By topsExpandBtnLocator = By.cssSelector("#categories_block_left > div > ul > li:nth-child(1) > span");
    private final By topsSubCategoriesListLocator = By.cssSelector("#categories_block_left > div > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
    private final By topsCatalogCheckboxLocator =By.xpath("//input[@id='layered_category_4']");
    private final By topsSubcategoryLinkLocator = By.xpath("//div[@class='subcategory-image']//a[@title='Tops']");

    private final By dressesCategoryLinkLocator = By.xpath("//div[@class='block_content']//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses']");
    private final By dressesExpandBtnLocator = By.cssSelector("div[class='block_content'] li[class='last'] span[class='grower CLOSE']");
    private final By dressesSubCategoriesListLocator = By.cssSelector("#categories_block_left > div > ul > li.last > ul > li:nth-child(1) > a");
    private final By dressesCatalogCheckboxLocator = By.xpath("//input[@id='layered_category_8']");
    private final By dressesSubCategoryLinkLocator = By.xpath("//div[@class='subcategory-image']//a[@title='Dresses']");

    private final By categoryNameLocator = By.cssSelector(".cat-name");
    private final By enabledFilterCategoryLocator = By.cssSelector("div[id='enabled_filters'] ul li");

    private final By firstProductContainerLocator = By.cssSelector("#center_column > ul > li:nth-child(1) > div");

    private final By priceOfFirstProductLocator = By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > div.content_price > span");

    private final By addToCartBtnFirstContainer = By.xpath("//a[@data-id-product='1']/child::span");

    private final By proceedToCheckoutBtn = By.cssSelector("a[title='Proceed to checkout']");

    public WomenCategory(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickTopsCategoryLink(){
        click(topsCategoryLinkLocator);
    }

    public void clickTopsExpandBtn(){
        click(topsExpandBtnLocator);
    }

    public void clickTopsCatalogCheckbox(){
        click(topsCatalogCheckboxLocator);
    }

    public void clickTopsSubcategoryLink(){
        click(topsSubcategoryLinkLocator);
    }

    public String getTopsFirstSubcategoryList(){
        return getText(topsSubCategoriesListLocator);
    }

    public void clickDressesCategoryLink(){
        click(dressesCategoryLinkLocator);
    }

    public void clickDressesExpandBtn(){
        click(dressesExpandBtnLocator);
    }

    public void clickDressesCatalogCheckbox(){
        click(dressesCatalogCheckboxLocator);
    }

    public void clickDressesSubcategoryLink(){
        click(dressesSubCategoryLinkLocator);
    }

    public String getDressesFirstSubcategoryListItem(){
        return getText(dressesSubCategoriesListLocator);
    }

    public String getCategoryName(){
        return getText(categoryNameLocator);
    }

    public String getNameOfCategoryFilter(){
        return getText(enabledFilterCategoryLocator);
    }

    public void hoverOverFirstProductContainer(){
        hover(firstProductContainerLocator);
    }

    public void clickAddToCartBtn(){
        click(addToCartBtnFirstContainer);
    }


    public void clickCheckoutBtn(){
        click(proceedToCheckoutBtn);
    }

    public String getTextOfFirstAddToCartBtn(){
        return getText(addToCartBtnFirstContainer);
    }

    public String getPriceOfFirstProduct(){
        return getText(priceOfFirstProductLocator);
    }
}
