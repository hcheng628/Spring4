package us.supercheng.spring4.entity;

import java.util.Map;

public class RaceGame {
	private int id;
	private Map<Integer, Person> drivers;
	
	
	public RaceGame(int id, Map<Integer, Person> drivers) {
		super();
		this.id = id;
		this.drivers = drivers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Integer, Person> getDrivers() {
		return drivers;
	}

	public void setDrivers(Map<Integer, Person> drivers) {
		this.drivers = drivers;
	}

	@Override
	public String toString() {
		return "RaceGame [id=" + id + ", drivers=" + drivers + "]";
	}
}