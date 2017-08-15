package us.supercheng.spring4.spel.entity;

public class Person {
	
	private String name;
	private String currentAddress;
	private String info;
	private Car myCar;
	
	public Person() {
		System.out.println("Person Constructor");
		this.name = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Person name Setter");
		this.name = name;
	}
	
	public void justSayHi() {
		System.out.println(this.name + " says Hi!");
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	

	public Car getMyCar() {
		return myCar;
	}

	public void setMyCar(Car myCar) {
		this.myCar = myCar;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", currentAddress=" + currentAddress + ", info=" + info + ", myCar=" + myCar
				+ "]";
	}
}