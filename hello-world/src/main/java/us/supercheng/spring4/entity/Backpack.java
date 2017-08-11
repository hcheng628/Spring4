package us.supercheng.spring4.entity;

public class Backpack {
	
	private String brand;
	private Phone phone;
	private Laptop laptop;
	
	public Backpack() {
		super();
	}
	
	public Backpack(String brand, Phone phone, Laptop laptop) {
		this.brand = brand;
		this.phone = phone;
		this.laptop = laptop;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Backpack [brand=" + brand + ", phone=" + phone + ", laptop=" + laptop + "]";
	}
}