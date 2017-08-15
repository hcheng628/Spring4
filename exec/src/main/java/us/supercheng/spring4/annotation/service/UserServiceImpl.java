package us.supercheng.spring4.annotation.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService{

	public void createNewUser() {
		System.out.println("createNewUser() UserServiceImpl");	
	}
}