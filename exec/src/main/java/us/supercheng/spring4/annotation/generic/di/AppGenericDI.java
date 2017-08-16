package us.supercheng.spring4.annotation.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppGenericDI {

	private static final String SPRING_BEAN_IOC_FILE = "SpringBean-Generic-DI.xml";
	
	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
		UserService userService = (UserService) appContext.getBean("userService");
		AdminService adminService = (AdminService) appContext.getBean("adminService");
		// System.out.println(userService);
		userService.createNewUser();
		adminService.createNewUser();
	}
}