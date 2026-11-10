import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Grace Hopper", "555-0000");
    }

    @Test
    void constructor_setsNameCorrectly() {
        Contact ada = new Contact("Ada Lovelace", "+1 617 555 0101");
        assertEquals("Ada Lovelace", ada.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        Contact ada = new Contact("Ada Lovelace", "+1 617 555 0101");
        assertEquals("+1 617 555 0101", ada.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        assertEquals("Grace Hopper", contact.getName());
    }

    @Test
    void toString_containsName() {
        assertTrue(contact.toString().contains("Grace Hopper"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(contact.toString().contains("555-0000"));
    }

    @Test
    void contactsWithSameName_keepTheirOwnPhoneNumbers() {
        Contact first = new Contact("Ada Lovelace", "555-0101");
        Contact second = new Contact("Ada Lovelace", "555-0202");

        assertNotSame(first, second);
        assertEquals("555-0101", first.getPhone());
        assertEquals("555-0202", second.getPhone());
    }
}
