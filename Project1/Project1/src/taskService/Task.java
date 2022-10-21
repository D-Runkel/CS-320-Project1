package taskService;

public class Task {
	
	@SuppressWarnings("unused")
	private String id, name, desc;

	//class must be initialized with values.
	public Task(String id, String name, String desc) {
		
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("ID must be non null and less than 10 characters");
		}
		this.id = id;
		this.setName(name);
		this.setDesc(desc);
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public void setName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name: name too long (>20 char)");
		}
		this.name = name;
	}
	
	public void setDesc(String desc) {
		if(desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invaild desc: desc too long");
		}
		this.desc = desc;
	}
	
}
