package us.supercheng.spring4.aop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.aop.spring.service.ICal;

public class AppXMLConfig {
    private final static String SPRING_CONF_FILE = "SpringBean-XMLConfig.xml";

    public static void main(String [] args ) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_CONF_FILE);
        ICal cal = (ICal) appContext.getBean("calImplXMLConfig");
        cal.mult(100,100);
    }
}