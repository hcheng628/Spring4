package us.supercheng.spring4.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spring.jdbc.dao.EmpDao;
import us.supercheng.spring4.spring.jdbc.service.EmpService;

public class App {
    private final static String SPRING_CONF_FILE = "SpringBean-Config.xml";

    public static void main(String [] args ) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_CONF_FILE);
        EmpService empDao = (EmpService) appContext.getBean("empDao");
        System.out.println();
    }
}