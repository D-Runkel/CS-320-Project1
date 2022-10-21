package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;


class ContactTest {

	
	@Test
	void testContactId() {
		Contact contact = new Contact("12345");
		assertTrue(contact.getId().equals("12345"));
	}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("12345678910");
		});
	}
	
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact(null);
		});
	}
	
	@Test
	void testContactFirstName() {
		Contact contact = new Contact("12345");
		contact.setFirstName("Babadook");
		assertTrue(contact.getFirstName().equals("Babadook"));
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1").setFirstName("12345678910");
		});
	}
	
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1").setFirstName(null);
		});
	}
	
	@Test
	void testContactLastName() {
		Contact contact = new Contact("12345");
		contact.setLastName("L337H4X");
		assertTrue(contact.getLastName().equals("L337H4X"));
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1").setLastName("12345678910");
		});
	}
	
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1").setLastName(null);
		});
	}
	
	@Test
	void testContactPhone() {
		Contact contact = new Contact("12345");
		contact.setPhoneNumber("9208572007");
		assertTrue(contact.getPhoneNumber().equals("9208572007"));
	}
	
	@Test
	void testPhoneLengthTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1").setPhoneNumber("12345678910");
		});
	}
	
	@Test
	void testPhoneLengthTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1").setPhoneNumber("12345");
		});
	}
	
	@Test
	void testContactAddress() {
		Contact contact = new Contact("12345");
				contact.setAddress("502 Walleby way, Sydney");
		assertTrue(contact.getAddress().equals("502 Walleby way, Sydney"));
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1").setAddress("There should be more than 30 characters in this sentence.");
		});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1").setAddress(null);
		});
	}
	
}
