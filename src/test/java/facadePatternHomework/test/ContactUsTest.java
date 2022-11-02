package facadePatternHomework.test;

import facadePatternHomework.facades.ContactUsFacade;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ContactUsTest {

    private WebDriver driver;

    @BeforeAll
    static void globalSetup(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void testSetup(){


        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("Send a valid message to customer service")
    public void validMessageToCustomerService(){

        //Arrange
        String expectedText="Your message has been successfully sent to our team.";
        ContactUsFacade facade = new ContactUsFacade(driver);

        //Act
        String actualText = facade.sendMessageToCustomerService("tester@email.de", "7781A", "This is a random message!");

        //Assert
        assertThat(actualText, containsString(expectedText));
    }


    @Test
    @DisplayName("Sending message fails due to missing message text")
    public void messageTextMissing(){

        //Arrange
        String expectedText="The message cannot be blank.";
        ContactUsFacade facade = new ContactUsFacade(driver);

        //Act
        String actualText = facade.sendMessageWithoutTextToCustomerService("58712");

        //Assert
        assertThat(actualText, containsString(expectedText));
    }


    @Test
    @DisplayName("Sending message fails due invalid email")
    public void invalidEmail(){

        //Arrange
        String expectedText="Invalid email address.";
        ContactUsFacade facade = new ContactUsFacade(driver);

        //Act
        String actualText = facade.sendMessageWithInvalidEmailToCustomerService("7781A");

        //Assert
        assertThat(actualText, containsString(expectedText));

    }


}
