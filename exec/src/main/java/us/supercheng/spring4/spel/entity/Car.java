package us.supercheng.spring4.spel.entity;

public class Car {

	private String brand;
	private String name;
	private double msrp;
	private int topSpeed;
	
	public Car() {
		super();
	}
	
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", name=" + name + ", msrp=" + msrp + ", topSpeed=" + topSpeed + "]";
	}
}