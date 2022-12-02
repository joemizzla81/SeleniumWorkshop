package allure.facades;


import allure.pages.WomenCategory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;



public class WomenCategoryFacadeMitAllure {

    public String womenCategory_Page_Url = "http://automationpractice.com/index.php?id_category=3&controller=category";
    public WomenCategory womenCategory;

    public WomenCategoryFacadeMitAllure(WebDriver driver) {

        womenCategory = new WomenCategory(driver, womenCategory_Page_Url);

    }

    @Step("Select category: {category}")  //Allure
    public String chooseCategory(String category){

        womenCategory.open();
        womenCategory.clickCategoryLink(category);

        return womenCategory.getCategoryName();
    }

    @Step("Choose Subcategory: {category}")  //Allure
    public String chooseSubCategory (String category){

        womenCategory.open();
        womenCategory.clickSubCategoryLink(category);

        return womenCategory.getCategoryName();
    }
}
