package us.supercheng.spring4.jdbc.transaction.service.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.jdbc.transaction.entity.Customer;
import us.supercheng.spring4.jdbc.transaction.service.CustomerServiceImplDB;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerService_Test {

    ApplicationContext appContext;
    CustomerServiceImplDB customerServiceImplDB;

    @Before
    public void warmUp() {
        this.appContext = new ClassPathXmlApplicationContext("Spring-IoC-Config.xml");
        this.customerServiceImplDB = (CustomerServiceImplDB) this.appContext.getBean("customerServiceImplDB");
        System.out.println(this.customerServiceImplDB);
    }

    @Test
    public void a_add_Customer_Service_Test() {
        Customer customer = new Customer();
        customer.setId(99);
        customer.setUsername("Test Customer");
        customer.setBalance(5500.00);
        System.out.println(this.customerServiceImplDB.addCustomerService(customer));
    }

    @Test
    public void b_get_CustomerById_Service_Test() {
        System.out.println(this.customerServiceImplDB.getCustomerByIdService(1));
    }

    @Test
    public void c_update_CustomerById_Service_Test() {
        Customer customer = new Customer();
        customer.setId(99);
        customer.setUsername("Update Customer");
        customer.setBalance(5500.00);
        System.out.println(this.customerServiceImplDB.updateCustomerByIdService(customer));
    }

    @Test
    public void d_del_CustomerById_Service_Test() {
        System.out.println(this.customerServiceImplDB.delCustomerByIdService(99));
    }
}