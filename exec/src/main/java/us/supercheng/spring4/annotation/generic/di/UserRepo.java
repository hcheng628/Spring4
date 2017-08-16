package us.supercheng.spring4.annotation.generic.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo extends BaseRepo<User> {
	
//	@Autowired
//	private User user;
//	
//	public UserRepo() {
//		super();
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
}