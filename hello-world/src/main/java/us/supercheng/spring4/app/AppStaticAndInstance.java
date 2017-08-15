package us.supercheng.spring4.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.staticandinstance.entity.Car;

public class AppStaticAndInstance {
	private static final String SPRING_BEAN_IOC_FILE = "SpringBean-StaticAndInstance.xml";

	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
		Car carA = (Car) appContext.getBean("staticMethod");
		Car carB = (Car) appContext.getBean("instanceMethod");
		System.out.println(carA);
		System.out.println(carB);
	}
}
