package us.supercheng.spring4.postbeanprocessor.entity;

public class Sport {
	
	private String name;

	public Sport() {
		super();
		System.out.println("Sport() Default Constructor");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}
	
	public void start() {
		System.out.println("start()");
	}
	
	public void end() {
		System.out.println("end()");
	}

	@Override
	public String toString() {
		return "Sport [name=" + name + "]";
	}	
}