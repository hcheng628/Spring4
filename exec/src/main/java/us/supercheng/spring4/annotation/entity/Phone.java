package us.supercheng.spring4.annotation.entity;

import org.springframework.stereotype.Component;

//@Component
public class Phone implements IDevice {
	private String brand;
	
	public Phone() {
		super();
		// System.out.println("Phone Constructor");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Phone [brand=" + brand + "]";
	}

	public void deviceName() {
		System.out.println("This is a Phone.");
	}
}