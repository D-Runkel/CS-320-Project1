package contactService;

import java.util.ArrayList;
import java.util.Iterator;

public class ContactService {
	
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	
	//Returns contact by contact ID, else returns null
	public Contact getContact(String Id) {
		
		Iterator<Contact> it = this.contactList.iterator();
		
		while(it.hasNext()) {
			Contact tmp = it.next();
			if(Id == tmp.getId()) {
				return tmp;
			}
		}
		return null; 
	}
	
	//addContact checks for a unique Id in the instance. Will throw an illegal argument exception if duplicate exists.
	public void addContact(String id) {
		
		//logic to find matching id
		if(getContact(id) != null) {
			throw new IllegalArgumentException("id must be unique");
		}
		//logic adding the new contact if id is unique
		this.contactList.add(new Contact(id));
	}
	
	public void deleteContact(String id) {
		
		Iterator<Contact> it = this.contactList.iterator();
		
		while(it.hasNext()) {
			
			Contact tmp = it.next();
			if(tmp.getId() == id) {
				it.remove();
				return;
			}
		}
		throw new IllegalArgumentException("Contact doesn't exist.");
	}
	
	
	public void updateContactFirstName(String Id, String firstName) {
		
		Contact contact = this.getContact(Id);
		
		if(contact != null) {
			contact.setFirstName(firstName);
		}	
	}
	
	public void updateContactLastName(String Id, String lastName) {
		
		Contact contact = this.getContact(Id);
		
		if(contact != null) {
			contact.setLastName(lastName);
		}	
	}
	
	public void updateContactNumber(String Id, String number) {
		
		Contact contact = this.getContact(Id);
		
		if(contact != null) {
			contact.setPhoneNumber(number);
		}	
	}
	
	public void updateAddress(String Id, String address) {
		
		Contact contact = this.getContact(Id);
		
		if(contact != null) {
			contact.setAddress(address);
		}	
	}
}
