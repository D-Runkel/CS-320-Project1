package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import contactService.ContactService;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("1234");
		assertTrue(service.getContact("1234").getId().equals("1234"));
	}
	
	@Test
	void testUniqueContact() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			ContactService service = new ContactService();
			service.addContact("1");
			service.addContact("1");
		});
	}
	
	//should throw due to absence of contact
	@Test
	void testDeleteContact() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			ContactService service = new ContactService();
			service.addContact("1");
			service.deleteContact("1");
			service.deleteContact("1");
		});
	}
	
	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.addContact("1");
		service.updateContactFirstName("1", "John");
		assertTrue(service.getContact("1").getFirstName().equals("John"));
	}
	
	@Test
	void testUpdateLastName() {
		ContactService service = new ContactService();
		service.addContact("1");
		service.updateContactLastName("1", "Runkel");
		assertTrue(service.getContact("1").getLastName().equals("Runkel"));
	}
	
	@Test
	void testUpdateNumber() {
		ContactService service = new ContactService();
		service.addContact("1");
		service.updateContactNumber("1", "7899001234");
		assertTrue(service.getContact("1").getPhoneNumber().equals("7899001234"));
	}
	
	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.addContact("1");
		service.updateAddress("1", "502 Walleby Way, Sydney");
		assertTrue(service.getContact("1").getAddress().equals("502 Walleby Way, Sydney"));
	}
	
	
	

}
