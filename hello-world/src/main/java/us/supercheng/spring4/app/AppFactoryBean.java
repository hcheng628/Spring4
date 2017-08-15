package us.supercheng.spring4.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.factorybean.entity.Car;

public class AppFactoryBean {
	private static final String SPRING_BEAN_IOC_FILE = "SpringBean-FactoryBean.xml";

	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
		Car carA = (Car) appContext.getBean("carFactoryBean");
		Car carB = (Car) appContext.getBean("carFactoryBean");
		System.out.println(carA == carB);
		System.out.println();
	}
}