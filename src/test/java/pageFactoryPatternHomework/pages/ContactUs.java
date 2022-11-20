package pageFactoryPatternHomework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUs extends BasePage {

    @FindBy(id = "id_contact")
    private WebElement  subjectHeading;

    @FindBy(id = "email")
    private WebElement emailAddressInput;

    @FindBy(id="id_order")
    private WebElement orderReferenceInput;

    @FindBy(id="message")
    private WebElement messageBoxInput;

    @FindBy(id="submitMessage")
    private WebElement sendBtn;

    @FindBy(css="#center_column > div > ol > li")
    private WebElement failureMessage;

    @FindBy(css = "#center_column > p")
    private WebElement successMessage;


    private WebDriver driver;

    public ContactUs(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void selectHeading(String heading){

        selectOption(subjectHeading, heading);

    }

    public void enterEmailAddress(String email){

        type(emailAddressInput, email);

    }

    public void enterOrderReference(String orderReference){

        type(orderReferenceInput, orderReference);
    }

    public void enterMessage(String message){

        type(messageBoxInput, message);
    }

    public void clickSendBtn(){

       click(sendBtn);
    }

    public String getSuccessMessage(){

        return getText(successMessage);
    }

    public String getFailureMessage(){

        return getText(failureMessage);
    }

}
