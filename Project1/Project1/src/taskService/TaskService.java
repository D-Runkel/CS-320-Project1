package taskService;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskService {
	
	ArrayList<Task> taskList = new ArrayList<Task>();
	
	public Task getTask(String id) {
		
		Iterator<Task> it = taskList.iterator();
		while(it.hasNext()) {
			Task tmp = it.next();
			if(tmp.getId() == id) {
				return tmp;
			}
		}
		//else
		throw new IllegalArgumentException("Task not found.");
	}
	
	public void addTask(String id, String name, String desc) {
		
		//taskService checks for unique id here
		Iterator<Task> it = taskList.iterator();
		while(it.hasNext()) {
			Task tmp = it.next();
			if(tmp.getId() == id ) {
				throw new IllegalArgumentException("Id invalid: Already in use");
			}	
		}
		taskList.add(new Task(id, name, desc));
	}
	
	public void updateName(String id, String name) {
		
		this.getTask(id).setName(name); 
		
	}
	
	public void updateDesc(String id, String desc) {
		
		this.getTask(id).setDesc(desc);
	}
	
	public void deleteTask(String id) {
		
		Iterator<Task> it = this.taskList.iterator();
		while(it.hasNext()) {
			Task tmp = it.next();
			if(tmp.getId() == id ) {
				it.remove();
			}
		}
	}
}
