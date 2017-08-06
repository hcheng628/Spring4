package us.supercheng.spring4.entity;

public class Person {
	private String name;
	
	public Person() {
		System.out.println("Person Constructor");
		this.name = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Person name Setter");
		this.name = name;
	}
	
	public void justSayHi() {
		System.out.println(this.name + " says Hi!");
	}
}