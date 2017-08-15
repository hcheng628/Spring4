package us.supercheng.spring4.staticandinstance.entity;

import java.util.*;

public class CarFactory {
	private static Map<String, Car> cars;
	
	static {
		cars = new HashMap<String,Car>();
		cars.put("1", new Car("428i", "BMW", "55000"));
		cars.put("1", new Car("E 350", "Benz", "55000"));
	}
	
	public static Car getCar(String keyName) {
		return cars.get(keyName);
	}
}