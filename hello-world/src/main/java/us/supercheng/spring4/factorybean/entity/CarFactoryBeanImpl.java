package us.supercheng.spring4.factorybean.entity;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBeanImpl implements FactoryBean<Car>{
	
	private Car car;
	
	public CarFactoryBeanImpl(String brand, String name, double msrp, int topSpeed) {
		this.car = new Car(brand, name, msrp, topSpeed);
	}

	public Car getObject() throws Exception {
		return this.car;
	}

	public Class<?> getObjectType() {
		return Car.class;
	}

	public boolean isSingleton() {
		return true;
	}
}