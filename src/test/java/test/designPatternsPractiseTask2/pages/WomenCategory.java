package test.designPatternsPractiseTask2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class WomenCategory extends BasePage {

    private WebDriver driver;

    public WomenCategory(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By topsCategoryLinkLocator = By.xpath("//div[@class='block_content']//a[normalize-space()='Tops']");
    By topsExpandBtnLocator = By.cssSelector("#categories_block_left > div > ul > li:nth-child(1) > span");
    By topsSubCategoriesListLocator = By.cssSelector("#categories_block_left > div > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
    By topsCatalogCheckboxLocator =By.xpath("//input[@id='layered_category_4']");
    By topsSubcategoryLinkLocator = By.xpath("//div[@class='subcategory-image']//a[@title='Tops']");

    By dressesCategoryLinkLocator = By.xpath("//div[@class='block_content']//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses']");
    By dressesExpandBtnLocator = By.cssSelector("div[class='block_content'] li[class='last'] span[class='grower CLOSE']");
    By dressesSubCategoriesListLocator = By.cssSelector("#categories_block_left > div > ul > li.last > ul > li:nth-child(1) > a");
    By dressesCatalogCheckboxLocator = By.xpath("//input[@id='layered_category_8']");
    By dressesSubCategoryLinkLocator = By.xpath("//div[@class='subcategory-image']//a[@title='Dresses']");

    By categoryNameLocator = By.cssSelector(".cat-name");
    By enabledFilterCategoryLocator = By.cssSelector("div[id='enabled_filters'] ul li");

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
}
