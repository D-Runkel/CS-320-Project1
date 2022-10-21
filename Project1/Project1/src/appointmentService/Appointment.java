package appointmentService;

import java.util.Date;

public class Appointment {
	
	String id;
	Date date;
	String desc;
	
	public Appointment(String id, Date date, String desc) {
		
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.id = id;
		this.setDate(date);
		this.setDesc(desc);
	
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setDate(Date date) {
		Date today = new Date();
		if( date.before(today) ) {
			throw new IllegalArgumentException("INVALID DATE:Appointment date before current date");
		}
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDesc(String desc) {
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.desc = desc;
	}
	
	public String getDesc() {
		return this.desc;
	}

}
