package us.supercheng.spring4.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.entity.Backpack;

public class App2 {
	
	private static final String SPRING_BEAN_IOC_FILE = "SpringBeanDef2.xml";

	
	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
		Backpack backpack = (Backpack) appContext.getBean("backpack");
		System.out.println(backpack);
	}
}