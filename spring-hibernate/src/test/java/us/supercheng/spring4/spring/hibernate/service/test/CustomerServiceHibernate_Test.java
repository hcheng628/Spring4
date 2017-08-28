package us.supercheng.spring4.spring.hibernate.service.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spring.hibernate.entity.Customer;
import us.supercheng.spring4.spring.hibernate.service.impl.BookServiceImpl;
import us.supercheng.spring4.spring.hibernate.service.impl.CustomerServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServiceHibernate_Test {

    final int customerId = 1;

    private ApplicationContext applicationContext;
    private CustomerServiceImpl customerServiceImpl;

    {
        this.applicationContext = new ClassPathXmlApplicationContext("Spring-AoP-Config.xml");
        this.customerServiceImpl = this.applicationContext.getBean(CustomerServiceImpl.class);
    }

    @Test
    public void a_addCustomer_Service_Test () {
        Customer customer = new Customer();
        customer.setUsername("Tester");
        customer.setBalance(1280.00);
        System.out.println(this.customerServiceImpl.addCustomerService(customer));
    }

    @Test
    public void b_getCustomerById_Service_Test () {
        System.out.println(this.customerServiceImpl.getCustomerByIdService(customerId));
    }

    @Test
    public void c_updateBookByIsbn_Service_Test() {
        Customer customer = new Customer();
        customer.setUsername("TesterUpdate");
        customer.setBalance(1280.00);
        customer.setId(customerId);
        System.out.println(this.customerServiceImpl.updateCustomerByIdService(customer));
    }

    @Test
    public void d_deleteBookByIsbn_Service_Test() {
        System.out.println(this.customerServiceImpl.delCustomerByIdService(customerId));
    }
}