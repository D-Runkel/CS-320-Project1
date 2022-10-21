package tests;

import static org.junit.jupiter.api.Assertions.*;
import appointmentService.Appointment;
import appointmentService.AppointmentService;

import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	@Test
	void testApptService() {
		
		AppointmentService service = new AppointmentService();
		Date date = new Date(2030 - 1900,  01, 01 );
		service.addAppt("0", date , "description");
		
		Appointment appt = service.getAppt("0");
		assertTrue(appt.getId() == "0");
		assertTrue(appt.getDate() == date);
		assertTrue(appt.getDesc() == "description");
		
	}
	
	@Test
	void testUniqueApptId() {
		
		AppointmentService service = new AppointmentService();
		Date date = new Date(2030 - 1900,  01, 01 );
		service.addAppt("0", date , "description");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			service.addAppt("0", date , "description");	
		});
	}
	
	@Test
	void testUpdateApptDate() {
		
		AppointmentService service = new AppointmentService();
		Date date = new Date(2040-1900, 01,01);
		service.addAppt("0", new Date(2030 - 1900,  01, 01 ) , "description");
		
		service.updateApptDate("0", date );
		assertTrue(service.getAppt("0").getDate()== date);
		
	}
	
	@Test
	void testUpdateDesc() {
		
		AppointmentService service = new AppointmentService();
		service.addAppt("0", new Date(2030 - 1900,  01, 01 ) , "description");
		
		service.updateApptDesc("0", "Hello");
		assertTrue(service.getAppt("0").getDesc()== "Hello");
	}
	
	@Test
	void testDeleteAppt() {
		AppointmentService service = new AppointmentService();
		
		service.addAppt("0", new Date(2030-1900,01,01 ) , "description");
		service.deleteAppt("0");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			service.getAppt("0");	
		});
	}

}
