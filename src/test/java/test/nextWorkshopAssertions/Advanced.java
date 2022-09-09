package test.nextWorkshopAssertions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Advanced {

    @Test
    void assertException(){

        Person a = null;
        assertThrows(NullPointerException.class, () -> {a.getFirstName().toUpperCase();});

        Person b = new Person("Jessy", "Niada");
        assertThrows(IllegalArgumentException.class, () -> {b.setFirstName("");});
        assertDoesNotThrow(() -> b.setFirstName("Lambda"));
    }

    @Test
    void listOfAsserts() {

        Person a = null;
        Person b = new Person("Jessy", "Niada");

        assertAll(
                () -> assertThrows(ArithmeticException.class, () -> b.setFirstName("")),
                () -> assertEquals(2,3),
                () -> assertThrows(IllegalArgumentException.class, () -> b.setFirstName(""))
        );
    }
}
