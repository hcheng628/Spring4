package us.supercheng.spring4.entity;

public class Car {

	private String brand;
	private String name;
	private double msrp;
	private int topSpeed;
	
	public Car(String brand, String name, double msrp, int topSpeed) {
		super();
		this.brand = brand;
		this.name = name;
		this.msrp = msrp;
		this.topSpeed = topSpeed;
	}
	
	public Car(String brand, String name, int topSpeed) {
		super();
		this.brand = brand;
		this.name = name;
		this.topSpeed = topSpeed;
	}
	
	public Car(String brand, String name, double msrp) {
		super();
		this.brand = brand;
		this.name = name;
		this.msrp = msrp;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", name=" + name + ", msrp=" + msrp + ", topSpeed=" + topSpeed + "]";
	}
}
