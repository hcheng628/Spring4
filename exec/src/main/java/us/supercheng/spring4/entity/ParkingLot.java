package us.supercheng.spring4.entity;

import java.util.List;

public class ParkingLot {
	private Person manager;
	private List<Car> cars;
	
	
	public ParkingLot(Person manager, List<Car> cars) {
		super();
		this.manager = manager;
		this.cars = cars;
	}
	
	public Person getManager() {
		return manager;
	}
	public void setManager(Person manager) {
		this.manager = manager;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "ParkingLot [manager=" + manager + ", cars=" + cars + "]";
	}
	
}