package us.supercheng.spring4.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.supercheng.spring4.entity.Person;

public class App {

	private static final String SPRING_BEAN_IOC_FILE = "SpringBeanDef.xml";
	
	public static void main(String[]  args) {
		Person person = new Person();
		person.setName("Regular");
		person.justSayHi();
		
		// 1 Init IOC
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
		// 2 Get Person Instance from IOC
		Person personSpring = (Person) appContext.getBean("person");
		personSpring.justSayHi();
		
	}
}
