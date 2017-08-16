package us.supercheng.spring4.annotation.generic.di;

import org.springframework.stereotype.Component;

@Component
public class Admin {
	
	private String name;

	public Admin() {
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
		return "Admin [name=" + name + "]";
	}	
}
