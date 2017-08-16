package us.supercheng.spring4.annotation.generic.di;

import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{
	
//	private UserRepo userRepo;
//	
//	public UserService() {
//		super();
//	}
//
//	public UserRepo getUserRepo() {
//		return userRepo;
//	}
//
//	public void setUserRepo(UserRepo userRepo) {
//		this.userRepo = userRepo;
//	}
//	
	/*
	public void createNewUser(){
		System.out.println("createNewUser BaseService......");
		// this.userRepo.createNewUser();
	}
	*/
}