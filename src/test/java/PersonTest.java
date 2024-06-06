import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNameNull() {
        new Person(null, 25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNameEmpty() {
        new Person("", 25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAgeTooLow() {
        new Person("John Doe", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAgeTooHigh() {
        new Person("John Doe", 120);
    }

    @Test
    public void testValidPerson() {
        Person person = new Person("John Doe", 25);
        assertEquals("John Doe", person.getName());
        assertEquals(25, person.getAge());
    }
}
