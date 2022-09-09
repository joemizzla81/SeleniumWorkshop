package test.nextWorkshopAssertions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Basics {


    @Test
    void basicAssertionPattern() {
        //Arrange
        String expectedText = "Jetzt abonnieren";

        //Act
        String actualText = "Abonnieren";

        //Asserts
        // assertEquals(expectedText, actualText, "Order button is incorrect");
        assertNotEquals(1, 2, "Ids of different users are equals");
        assertEquals(new Person("Jessy", "Niada"), new Person("Jessy", "Niada"));
    }

    @Test
    void simplifiedAsserts() {
        boolean actualVal  = false;
        String text = null;
        assertTrue(actualVal, "Es ist falsch!");

        assertNull(text,"Text is not null");
        assertNotNull(text, "Text is null");

        // assertTrue(obj1 == obj2);
    }

}
