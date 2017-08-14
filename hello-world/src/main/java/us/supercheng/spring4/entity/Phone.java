package us.supercheng.spring4.entity;

public class Phone {
	
	private String brand;
	private String name;
	
	public Phone(){
		super();
		System.out.println("Phone Constructor ... ");
	}
	
	public Phone(String brand, String name){
		this.brand = brand;
		this.name = name;
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

	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", name=" + name + "]";
	}	
}