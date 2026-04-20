package Appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

	package contact;

	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;

	public class ContactTest {

	    // ? Valid contact
	    @Test
	    void testValidContact() {
	        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Street");
	        assertNotNull(c);
	    }

	    // ? NULL TESTS
	    @Test
	    void testNullId() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact(null, "John", "Doe", "1234567890", "123 Street");
	        });
	    }

	    @Test
	    void testNullFirstName() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", null, "Doe", "1234567890", "123 Street");
	        });
	    }

	    @Test
	    void testNullLastName() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", "John", null, "1234567890", "123 Street");
	        });
	    }

	    @Test
	    void testNullPhone() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", "John", "Doe", null, "123 Street");
	        });
	    }

	    @Test
	    void testNullAddress() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", "John", "Doe", "1234567890", null);
	        });
	    }

	    // ? LENGTH TESTS
	    @Test
	    void testIdTooLong() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("12345678901", "John", "Doe", "1234567890", "123 Street");
	        });
	    }

	    @Test
	    void testFirstNameTooLong() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", "ThisNameIsTooLong", "Doe", "1234567890", "123 Street");
	        });
	    }

	    @Test
	    void testLastNameTooLong() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", "John", "ThisLastNameIsTooLong", "1234567890", "123 Street");
	        });
	    }

	    @Test
	    void testAddressTooLong() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", "John", "Doe", "1234567890",
	                "This address is way too long to be valid for the system");
	        });
	    }

	    // ? PHONE FORMAT TESTS
	    @Test
	    void testPhoneTooShort() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", "John", "Doe", "12345", "123 Street");
	        });
	    }

	    @Test
	    void testPhoneWithLetters() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Contact("1", "John", "Doe", "12345abcde", "123 Street");
	        });
	    }
	}