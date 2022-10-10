package test.designPatternsPractiseTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactUs extends BasePage {

    private final By subjectHeadingLocator = By.id("id_contact");

    private final By emailAddressInputLocator = By.id("email");

    private final By orderReferenceInputLocator = By.id("id_order");

    private final By messageBoxInputLocator = By.id("message");

    private final By sendBtnLocator = By.id("submitMessage");

    private final By failureMessageLocator = By.cssSelector("#center_column > div > ol > li");

    private final By successMessageLocator = By.cssSelector("#center_column > p");


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
