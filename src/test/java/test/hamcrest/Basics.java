package test.hamcrest;

import org.junit.jupiter.api.*;
import test.nextWorkshopAssertions.Person;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Basics {

    @Test
    void hamcrestBasics(){
        // Pattern für asserts: assertThat("identifier", subject/test object/actualResult, Matcher)

        //Arrange
        Person a = new Person("Jessy", "Niada");
        Person b = new Person("John", "Wayne");

        //Act
        Person c = new Person("Jack", "Bauer"); //angenommen, das Ergebnis kommt aus einer Methode bzw. Schnittstellenaufruf

        //Asserts
        assertThat("first person check", c,equalTo((a)));
        assertThat(c, is(equalTo(a)));
        assertThat(34.9, not(notANumber()));
        assertTrue(Double.isNaN(34.9));
        assertThat(0.0/0, is(notANumber()));
        assertThat(c, is(anything()));
        assertThat(c, allOf(hasProperty("firstName"), instanceOf(Person.class), notNullValue()));
        assertThat(c, oneOf(hasProperty("firstName"), instanceOf(Person.class), notNullValue()));
        assertThat("JessyNiada", containsStringIgnoringCase("ssy"));
    }
}
