package us.supercheng.spring4.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.supercheng.spring4.entity.Backpack;
import us.supercheng.spring4.entity.Phone;

public class AppBeanScope {
	private static final String SPRING_BEAN_IOC_FILE = "SpringBeanDef3.xml";
	
	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);	
		Phone phoneA = (Phone)appContext.getBean("phone");
		Phone phoneB = (Phone)appContext.getBean("phone");

		System.out.println(phoneA == phoneB);
		
		Backpack backPack1 = (Backpack)appContext.getBean("backpack1");
		Backpack backpack2 = (Backpack)appContext.getBean("backpack2");
		Backpack backpack3 = (Backpack)appContext.getBean("backpack3");
		
		
		System.out.println("backPack1: " + backPack1);
		System.out.println("backPack2: " + backpack2);
		System.out.println("backpack3: " + backpack3);

	}
}
