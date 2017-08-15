package us.supercheng.spring4.staticandinstance.entity;

import java.util.HashMap;
import java.util.Map;

public class Car {
	private String name;
	private String brand;
	private String msrp;
	
	public Car(String name, String brand, String msrp) {
		super();
		this.name = name;
		this.brand = brand;
		this.msrp = msrp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMsrp() {
		return msrp;
	}
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", brand=" + brand + ", msrp=" + msrp + "]";
	}
}