package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import taskService.*;
class TaskServiceTest {

	@Test
	void testTaskService() {
		TaskService taskService = new TaskService();
		taskService.addTask("1","Foo", "Bar");
		
		//confirming we can add a task and retrieve it with known good params from Task
		assertTrue(taskService.getTask("1").getName() == "Foo");	
	}
	
	@Test
	void testTaskDeletion() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			TaskService taskService = new TaskService();
			taskService.addTask("0", "Clean car", "Bring to car wash and wipe windows");
			taskService.deleteTask("0");
			taskService.getTask("0");
		});
	}
	
	@Test
	void testTaskUnique() {
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			TaskService taskService = new TaskService();
			taskService.addTask("0", "Eat Salad", "Less than 500 kcals");
			taskService.addTask("0", "Eat Salad", "Less than 500 kCals");
		});
	}
	
	@Test
	void testTaskServiceUpdateName() {
		TaskService taskService = new TaskService();
		taskService.addTask("1","Joe", "Bar");
		taskService.updateName("1", "Foo");
		
		assertTrue(taskService.getTask("1").getName() == "Foo");	
	}
	
	@Test
	void testTaskServiceUpdateDesc() {
		TaskService taskService = new TaskService();
		taskService.addTask("1","Foo", "");
		taskService.updateDesc("1", "Bar");
		
		assertTrue(taskService.getTask("1").getDesc() == "Bar");	
	}
	
	

}
