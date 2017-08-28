package us.supercheng.spring4.spring.hibernate.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spring.hibernate.entity.Book;
import us.supercheng.spring4.spring.hibernate.entity.Customer;

public class Hibernate_SessionFactory_Test {
    private ApplicationContext applicationContext;
    private SessionFactory sessionFactory;

    @Before
    public void warmUp() {
        applicationContext = new ClassPathXmlApplicationContext("Spring-AoP-Config.xml");
    }

    @Test
    public void a_SessionFactory_Test() {
        this.sessionFactory = (SessionFactory) this.applicationContext.getBean("sessionFactory");
        // System.out.println(this.applicationContext.getBean("dbSourcePool"));
        // System.out.println(this.sessionFactory);
        Customer customer = new Customer();
        customer.setId(111);
        customer.setUsername("Test");
        customer.setBalance(999.99);
        Session session = this.sessionFactory.openSession();
        session.save(customer);
        session.close();
    }
}
