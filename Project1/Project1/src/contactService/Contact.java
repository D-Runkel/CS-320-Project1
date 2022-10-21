package contactService;


public class Contact {
	
	private String id, firstName, lastName, phoneNumber, address;
	
	//Contact must be initialized with an id by caller
	public Contact(String id) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		this.id = id;
	}
	
	//Accessors and Mutators
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() != 10 || phoneNumber == null) {
			throw new IllegalArgumentException("Invalid phoneNumber");
		}
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setAddress(String address) {
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}

	public String getId() {
		
		return this.id;
	}
	
}
