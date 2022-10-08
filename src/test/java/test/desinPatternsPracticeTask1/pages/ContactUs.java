package test.desinPatternsPracticeTask1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUs extends BasePage {

    By subjectHeadingLocator = By.id("id_contact");

    By emailAddressInputLocator = By.id("email");

    By orderReferenceInputLocator = By.id("id_order");

    By messageBoxInputLocator = By.id("message");

    By sendBtnLocator = By.id("submitMessage");

    By failureMessageLocator = By.cssSelector("#center_column > div > ol > li");

    By successMessageLocator = By.cssSelector("#center_column > p");


    private WebDriver driver;

    public ContactUs(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void selectHeading(String heading){

        selectOption(subjectHeadingLocator, heading);

    }

    public void enterEmailAddress(String email){

        type(emailAddressInputLocator, email);

    }

    public void enterOrderReference(String orderReference){

        type(orderReferenceInputLocator, orderReference);
    }

    public void enterMessage(String message){

        type(messageBoxInputLocator, message);
    }

    public void clickSendBtn(){

       click(sendBtnLocator);
    }

    public String getSuccessMessage(){

        return getText(successMessageLocator);
    }

    public String getFailureMessage(){

        return getText(failureMessageLocator);
    }

}
