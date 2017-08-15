package us.supercheng.spring4.app;

import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppDB {
	private static final String SPRING_BEAN_IOC_FILE = "SpringBeanDef2.xml";
	
	public static void main(String [] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_BEAN_IOC_FILE);		
		DataSource dbDS = (DataSource) appContext.getBean("dbSource");
		try {
			System.out.println("Check DB: " + dbDS.getConnection());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}