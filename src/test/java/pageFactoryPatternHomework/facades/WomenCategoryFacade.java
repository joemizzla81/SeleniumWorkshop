package pageFactoryPatternHomework.facades;


import pageFactoryPatternHomework.pages.WomenCategory;
import org.openqa.selenium.WebDriver;

public class WomenCategoryFacade {

    public String womenCategory_Page_Url = "http://automationpractice.com/index.php?id_category=3&controller=category";
    public WomenCategory womenCategory;

    public WomenCategoryFacade(WebDriver driver) {

        womenCategory = new WomenCategory(driver, womenCategory_Page_Url);

    }

}
