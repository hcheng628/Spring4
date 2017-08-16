package us.supercheng.spring4.annotation.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceAPIImpl implements IUserService {

	public void createNewUser() {
		System.out.println("createNewUser() UserServiceAPIImpl");
	}
}