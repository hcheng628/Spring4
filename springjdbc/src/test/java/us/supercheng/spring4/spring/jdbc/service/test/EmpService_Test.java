package us.supercheng.spring4.spring.jdbc.service.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spring.jdbc.entity.Emp;
import us.supercheng.spring4.spring.jdbc.service.EmpService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void e_add_Emp_Batch_Service_Test() {
        Emp a = new Emp();
        a.setFullName("AAA");
        a.setDeptId(111);
        a.setAge(11);
        a.setId(111);

        Emp b = new Emp();
        b.setFullName("BBB");
        b.setDeptId(222);
        b.setAge(22);
        b.setId(222);

        List<Emp> empList = new ArrayList<Emp>();
        empList.add(a);
        empList.add(b);

        int[] returnResult = this.empService.addEmpBatchService(empList);
        System.out.println(Arrays.asList(returnResult));
    }

    @Test
    public void f_update_Emp_Batch_Service_Test() {
        Emp aUpdate = new Emp();
        aUpdate.setFullName("new AAA");
        aUpdate.setDeptId(111);
        aUpdate.setAge(11);
        aUpdate.setId(111);

        Emp bUpdate = new Emp();
        bUpdate.setFullName("new BBB");
        bUpdate.setDeptId(222);
        bUpdate.setAge(22);
        bUpdate.setId(222);

        List<Emp> empList = new ArrayList<Emp>();
        empList.add(aUpdate);
        empList.add(bUpdate);

        int[] returnResult = this.empService.updateEmpBatchService(empList);
        System.out.println(Arrays.asList(returnResult));
    }

    @Test
    public void g_delete_Emp_Batch_Service_Test() {
        int [] empIdList = {111, 222};
        System.out.println(Arrays.asList(this.empService.deleteEmpBatchService(empIdList)));
    }

    @Test
    public void h_get_EmpList_ByDeptId_Service_Test() {
        int deptId = 1;
        System.out.println(Arrays.asList(this.empService.getEmpListByDeptIdService(deptId)));
    }
}