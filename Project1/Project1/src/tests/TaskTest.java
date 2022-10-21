package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import taskService.*;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("12345","Name","Description");
		assertTrue(task.getId()=="12345");
		assertTrue(task.getName()=="Name");
		assertTrue(task.getDesc()=="Description");	
	}
	
	@Test
	void testIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("12345678910", "", "");
		});
	}
	
	@Test
	void testIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task(null, "", "");
		});
	}
	
	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("", "My name is ... Tim ...", "");
		});
	}
	
	@Test
	void testNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("", null, "");
		});
	}
	
	@Test
	void testDescTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("", "", "Brave sir robbin, rode forth from camelot, he was not afraid to die, oh brave sir robbin!");
		});
	}
	
	@Test
	void testDescNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Task("","", null);
		});
	}
}
