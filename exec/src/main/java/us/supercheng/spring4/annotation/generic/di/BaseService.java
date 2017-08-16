package us.supercheng.spring4.annotation.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	
	@Autowired
	private BaseRepo<T> baserepo;
	
	public BaseService() {
		super();
	}

	public BaseRepo<T> getBaserepo() {
		return baserepo;
	}

	public void setBaserepo(BaseRepo<T> baserepo) {
		this.baserepo = baserepo;
	}

	public void createNewUser(){
		System.out.println("createNewUser BaseService......" + this.baserepo);
	}
}