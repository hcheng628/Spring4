package us.supercheng.spring4.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	public void add() {
		System.out.println("UserDao add() method");
	}
}