package us.supercheng.spring4.spel.entity;

public class Phone {
	
	private String brand;
	private String name;
	private String areaName;
	
	public Phone(){
		super();
		System.out.println("Phone Constructor ... ");
	}
	
	public Phone(String brand, String name, String areaName){
		this.brand = brand;
		this.name = name;
		this.areaName = areaName;
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", name=" + name + ", areaName=" + areaName + "]";
	}
}