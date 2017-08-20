package us.supercheng.spring4.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spring.jdbc.dao.EmpDao;
import us.supercheng.spring4.spring.jdbc.entity.Emp;
import us.supercheng.spring4.spring.jdbc.service.EmpService;

public class App {
    private final static String SPRING_CONF_FILE = "SpringBean-Config.xml";

    public static void main(String [] args ) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_CONF_FILE);
        EmpService empService = (EmpService) appContext.getBean("empService");
        // System.out.println(empService);
        Emp emp = new Emp();
        emp.setId(3);
        emp.setFullName("James");
        emp.setDeptId(3);
        emp.setAge(24);

        System.out.println(empService.addEmpService(emp));
        System.out.println(empService.getEmpService(1));

    }
}