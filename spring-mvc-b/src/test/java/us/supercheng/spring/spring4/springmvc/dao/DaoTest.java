package us.supercheng.spring.spring4.springmvc.dao;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import us.supercheng.spring.spring4.springmvc.config.AppConfig;
import us.supercheng.spring.spring4.springmvc.entity.Dept;
import us.supercheng.spring.spring4.springmvc.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = {AppConfig.class})
public class DaoTest {

    @Autowired
    public EmpDao empDao;

//    @Before
//    public void EmpDaoInit_Test() {
//        for (Emp each : this.empDao.getEmpList()) {
//            System.out.println(each);
//        }
//    }

    @Test
    public void a_create_EmpDao_Test() {
        String newEmpId = this.empDao.addEmpDao(new Emp("13","PF", "Chang", "p.chang@ymail.com",
                0, new Dept("1", "Business Unit")));
        if(newEmpId != null) {
            System.out.println("New EmpId: " + newEmpId);
        } else {
            System.out.println("Failed Add Emp");
        }
    }

    @Test
    public void b_retrieve_EmpDao_Test() {
        Emp emp = this.empDao.getEmpDao("13");
        if(emp.getId() != null) {
            System.out.println(emp);
        } else {
            System.out.println("Failed Get Emp");
        }
    }

    @Test
    public void c_update_EmpDao_Test() {
        Emp updateEmp = new Emp("13","PF", "Chang", "p.chang@ymail.com",
                0, new Dept("1", "IT"));
        if (this.empDao.updateEmpDao(updateEmp) != null) {
            System.out.println("Updated Emp Info: \r\n" + updateEmp);
        } else {
            System.out.println("Failed Update Emp");
        }

    }

    @Test
    public void d_delete_EmpDao_Test() {
        String delEmpId = this.empDao.delEmpDao("13");
        if(delEmpId != null) {
            System.out.println("Deleted Emp with EmpId: " + delEmpId);
        } else {
            System.out.println("Failed Delete Emp");
        }
    }
}