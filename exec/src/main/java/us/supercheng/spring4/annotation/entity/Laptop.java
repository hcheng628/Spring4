package us.supercheng.spring4.annotation.entity;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements IDevice {
	
	private String brand;
	
	public Laptop() {
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
		return "Laptop [brand=" + brand + "]";
	}
	

	public void deviceName() {
		System.out.println("This is a Laptop.");
	}
}