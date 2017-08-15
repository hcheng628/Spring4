package us.supercheng.spring4.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spel.entity.Car;
import us.supercheng.spring4.spel.entity.Person;
import us.supercheng.spring4.spel.entity.Phone;

public class AppSpEL {
	
	private static final String SPRING_BEAN_IOC_FILE = "SpringBean-SpEL.xml";

	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
//		Car car = (Car) appContext.getBean("spel_car");
//		Phone phone = (Phone) appContext.getBean("spel_phone");
//		System.out.println(car);
//		System.out.println(phone);
		
		Person person = (Person) appContext.getBean("spel_person");
				

		System.out.println(person);
	}
}