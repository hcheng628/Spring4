package us.supercheng.spring4.staticandinstance.entity;

import java.util.*;

public class CarInstance {
	private Map<String, Car> cars;
	
	public CarInstance() {
		cars = new HashMap<String, Car>();
		cars.put("1", new Car("TT", "Audi", "60000"));
		cars.put("2", new Car("Z4", "BMW", "60000"));
	}
	
	public Car getCar(String keyName) {
		return cars.get(keyName);
	}
}