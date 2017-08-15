package us.supercheng.spring4.annotation.entity;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	
	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}	
}