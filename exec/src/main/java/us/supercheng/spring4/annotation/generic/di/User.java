package us.supercheng.spring4.annotation.generic.di;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String name;

	public User() {
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
		return "User [name=" + name + "]";
	}	
}