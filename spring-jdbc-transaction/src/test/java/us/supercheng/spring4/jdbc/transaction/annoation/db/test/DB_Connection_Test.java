package us.supercheng.spring4.jdbc.transaction.annoation.db.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class DB_Connection_Test {

    private final String springIoCConfigFile = "Spring-IoC-Config.xml";
    ApplicationContext appContext;

    @Before
    public void warmUp() {
        this.appContext = new ClassPathXmlApplicationContext(springIoCConfigFile);
    }

    @Test
    public void c3p0_Test() {
        DataSource dataSource = (DataSource) this.appContext.getBean("dbSourcePool");
        System.out.println("DataSource: " + dataSource);
    }

    @Test
    public void namedParamJdbcTemplate() {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) appContext.getBean("namedParameterJdbcTemplate");
        System.out.println("NamedParameterJdbcTemplate: " + namedParameterJdbcTemplate);
    }

}