package facadePatternHomework.facades;

import facadePatternHomework.pages.ContactUs;
import org.openqa.selenium.WebDriver;

public class ContactUsFacade {

    public String contactUs_Page_Url = "http://automationpractice.com/index.php?controller=contact";
    public ContactUs contactUs;

    public ContactUsFacade(WebDriver driver){

        contactUs = new ContactUs(driver, contactUs_Page_Url);
    }

    public String sendMessageToCustomerService(String email, String orderReference, String message){

        contactUs.open();
        contactUs.selectHeading("Customer service");
        contactUs.enterEmailAddress(email);
        contactUs.enterOrderReference(orderReference);
        contactUs.enterMessage(message);
        contactUs.clickSendBtn();

        return contactUs.getSuccessMessage();

    }

    public String sendMessageWithoutTextToCustomerService(String orderReference){

        contactUs.open();
        contactUs.selectHeading("Customer service");
        contactUs.enterEmailAddress("randomuser@tester.de");
        contactUs.enterOrderReference(orderReference);
        contactUs.clickSendBtn();

        return contactUs.getFailureMessage();
    }

    public String sendMessageWithInvalidEmailToCustomerService(String orderReference){

        contactUs.open();
        contactUs.selectHeading("Customer service");
        contactUs.enterEmailAddress("invalid-email.de");
        contactUs.enterOrderReference(orderReference);
        contactUs.clickSendBtn();

        return contactUs.getFailureMessage();
    }
}
