package us.supercheng.spring.spring4.springmvc.service;

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
public class EmpServiceTest {
    @Autowired
    EmpService empService;

    @Test
    public void a_create_Test() {
        System.out.println("Add: " + this.empService.addEmp(new Emp("13","PF", "Chang", "p.chang@ymail.com",
                0, new Dept("1", "Business Unit"))));
    }

    @Test
    public void b_get_Test() {
        System.out.println("Get: " + this.empService.getEmp("13"));
    }

    @Test
    public void c_update_Test() {
        System.out.println("Update: " + this.empService.updateEmp(new Emp("13","PF", "Chang", "p.chang@ymail.com",
                0, new Dept("1", "IT"))));
    }

    @Test
    public void d_delete_Test() {
        System.out.println("Delete: " + this.empService.delEmp("13"));
    }
}