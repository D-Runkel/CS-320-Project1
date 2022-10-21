package appointmentService;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class AppointmentService {
	
	ArrayList<Appointment> apptList = new ArrayList<Appointment>();
	
	public Appointment getAppt(String id) {
		
		Iterator<Appointment> it = apptList.iterator();
		while(it.hasNext()) {
			Appointment tmp = it.next();
			if(tmp.id == id) {
				return tmp;
			}
		}
		throw new IllegalArgumentException("Appointment not found.");
	}
	
	public void addAppt(String id, Date date, String desc) {
		
		Iterator<Appointment> it = apptList.iterator();
		while(it.hasNext()) {
			Appointment tmp = it.next();
			if(id == tmp.id) {
				throw new IllegalArgumentException("Invalid id: unique id required.");
			}
		}
		apptList.add(new Appointment(id,date,desc));
	}
	
	public void updateApptDate(String id, Date date) {
		this.getAppt(id).setDate(date);
	}
	
	public void updateApptDesc(String id, String desc) {
		this.getAppt(id).setDesc(desc);
	}
	
	public void deleteAppt(String id) {
		
		Iterator<Appointment> it = apptList.iterator();
		while(it.hasNext()) {
			Appointment tmp = it.next();
			if(tmp.id == id) {
				it.remove();
			}
		}
	}
	
}
