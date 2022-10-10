package test.designPatternsPractiseTask.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.designPatternsPractiseTask.pages.ContactUs;


import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ContactUsTest {

    private WebDriver driver;

    private ContactUs contactUs;

    @BeforeEach
    public void setup(){

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        contactUs = new ContactUs(driver);

        driver.get("http://automationpractice.com/index.php?controller=contact");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterEach
    public void tearDown(){

        driver.quit();
    }

    @Test
    @DisplayName("Send a valid message to customer service")
    public void validMessage(){

        //Arrange
        String expectedText="Your message has been successfully sent to our team.";

        //Act
        contactUs.selectHeading("Customer service");
        contactUs.enterEmailAddress("unhappyuser@tester.de");
        contactUs.enterOrderReference("14578A");
        contactUs.enterMessage("Hi there, please tell me why my order has still not arrived!");
        contactUs.clickSendBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Assert
        assertThat(contactUs.getSuccessMessage(), containsString(expectedText));
    }

    @Test
    @DisplayName("Sending message fails due to missing message text")
    public void messageTextMissing(){

        //Arrange
        String expectedText="The message cannot be blank.";

        //Act
        contactUs.selectHeading("Customer service");
        contactUs.enterEmailAddress("unhappyuser@tester.de");
        contactUs.enterOrderReference("14578A");
        contactUs.clickSendBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Assert
        assertThat(contactUs.getFailureMessage(), containsString(expectedText));
    }

    @Test
    @DisplayName("Sending message fails due invalid email")
    public void invalidEmail(){

        //Arrange
        String expectedText="Invalid email address.";

        //Act
        contactUs.selectHeading("Customer service");
        contactUs.enterEmailAddress("ad");
        contactUs.enterOrderReference("14578A");
        contactUs.enterMessage("Hi there, please tell me why my order has still not arrived!");
        contactUs.clickSendBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Assert
        assertThat(contactUs.getFailureMessage(), containsString(expectedText));

    }
}
