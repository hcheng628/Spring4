package us.supercheng.spring.spring4.springmvc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import us.supercheng.spring.spring4.springmvc.config.AppConfig;
import us.supercheng.spring.spring4.springmvc.entity.Emp;
import java.beans.AppletInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
public class DaoTest {

    @Autowired
    public EmpDao empDao;

    @Test
    public void EmpDaoInit_Test() {
        for (Emp each : this.empDao.getEmpList()) {
            System.out.println(each);
        }
    }
}