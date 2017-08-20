package us.supercheng.spring4.spring.jdbc.service.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spring.jdbc.entity.Emp;
import us.supercheng.spring4.spring.jdbc.service.EmpService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpService_Test {
    private final static String SPRING_CONF_FILE = "SpringBean-Config.xml";
    private Emp emp;
    private EmpService empService;

    @Before
    public void warmUp(){
        this.emp = new Emp();
        this.emp.setId(9);
        this.emp.setFullName("Test");
        this.emp.setAge(29);
        this.emp.setDeptId(7);

        ApplicationContext appContext = new ClassPathXmlApplicationContext(SPRING_CONF_FILE);
        this.empService = (EmpService) appContext.getBean("empService");
    }

    @Test
    public void a_create_Emp_Service_Test() {
        this.empService.addEmpService(this.emp);
    }

    @Test
    public void b_retrieve_Emp_Service_Test() {
        this.empService.getEmpService(this.emp.getId());
    }

    @Test
    public void c_update_Emp_Service_Test() {
        this.emp.setFullName("NewTest");
        this.empService.updateEmpService(this.emp);
    }

    @Test
    public void d_delete_Emp_Service_Test() {
        this.empService.deleteEmpService(this.emp.getId());
    }
}
