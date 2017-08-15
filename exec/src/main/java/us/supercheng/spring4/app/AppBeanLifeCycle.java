package us.supercheng.spring4.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.supercheng.spring4.postbeanprocessor.entity.Sport;

public class AppBeanLifeCycle {
	
	private static final String SPRING_BEAN_IOC_FILE = "SpringBean-LifeCycle.xml";

	
	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);
		Sport sport = (Sport) appContext.getBean("sport");
		System.out.println("main println: " + sport);
	}
}