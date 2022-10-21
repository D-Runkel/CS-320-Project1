package tests;

import static org.junit.jupiter.api.Assertions.*;
import appointmentService.Appointment;

import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	@Test
	void testAppt() {
		Date date = new Date(2023 - 1900,01,01);
		Appointment appt = new Appointment("0",date,"Description");
		assertTrue(appt.getId() == "0");
		assertTrue(appt.getDate() == date);
		assertTrue(appt.getDesc() == "Description");
	}
	
	@Test
	void testApptIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment(null,new Date(2023 - 1900, 01,01), "Description");	
		});
	}
	
	@Test
	void testApptIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("1234567891011",new Date(2023 - 1900, 01,01), "Description");	
		});
	}
		
	@Test
	void testApptDatePast() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			Date date = new Date(2012 - 1900, 11, 27);
			new Appointment("0",date, "Description");	
		});
	}
	
	@Test
	void testApptDescTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("0",new Date(2023 - 1900, 01,01), "This description must be too long, certainly must be too long. Yes, I think it is.");	
		});
	}
	
	@Test
	void testApptDescNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("0",new Date(2023 - 1900, 01,01), null);	
		});
	}

}
