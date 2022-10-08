package test.designPatterns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Login extends BasePage {

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.cssSelector("#login > button");

    By successMessageLocator = By.cssSelector(".flash.success");

    private WebDriver driver;

    public Login(WebDriver driver){
        super(driver);
    }

    public void with(String username, String password){
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(loginButtonLocator);

    }

    public String getSuccessMessage(){

        return getText(successMessageLocator);
    }


}
