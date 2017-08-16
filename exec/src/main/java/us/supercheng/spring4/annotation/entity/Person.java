package us.supercheng.spring4.annotation.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	private IDevice device;
	
	public Person() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@Autowired
	public IDevice getDevice() {
		return device;
	}

	@Autowired(required=false)
	public void setDevice(@Qualifier("phone")IDevice device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", device=" + device + "]";
	}
}