package Appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");

        service.addContact(c);

        assertEquals(c, service.getContact("1"));
    }

    @Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();

        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        Contact c2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Ave");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(c2);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");

        service.addContact(c);
        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");

        service.addContact(c);
        service.updateFirstName("1", "Jane");

        assertEquals("Jane", service.getContact("1").getFirstName());
    }
}