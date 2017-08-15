package us.supercheng.spring4.annotation.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.annotation.controller.UserController;
import us.supercheng.spring4.annotation.repository.UserDao;
import us.supercheng.spring4.annotation.service.UserServiceImpl;

public class AnnoationApp {
	
	private static final String SPRING_BEAN_IOC_FILE = "SpringBean-Annotation.xml";
	
	public static void main(String [] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
		Person person = (Person) appContext.getBean("person");
		System.out.println(person);
		
		UserDao userDao = (UserDao) appContext.getBean("userDao");
		UserServiceImpl userService = (UserServiceImpl) appContext.getBean("userService");
		UserController userController = (UserController) appContext.getBean("userController");
		System.out.println(userDao);
		System.out.println(userService);
		System.out.println(userController);
	}
}