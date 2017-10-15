package us.supercheng.spring.spring4.springmvc.dao;

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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = {AppConfig.class})
public class DeptDaoTest {

    @Autowired
    public DeptDao deptDao;


    @Test
    public void b_retrieve_EmpDao_Test() {
        List<Dept> depts = this.deptDao.getAllDept();
        for (Dept eachDept :  depts) {
            System.out.println(eachDept);
        }
    }

}