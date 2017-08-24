package us.supercheng.spring4.jdbc.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.jdbc.transaction.dao.CustomerImplDB;
import us.supercheng.spring4.jdbc.transaction.entity.Customer;

@Service
public class CustomerServiceImplDB implements ICustomerService {

    @Autowired
    private CustomerImplDB customerImplDB;

    public CustomerImplDB getCustomerImplDB() {
        return customerImplDB;
    }

    public void setCustomerImplDB(CustomerImplDB customerImplDB) {
        this.customerImplDB = customerImplDB;
    }

    public int addCustomerService(Customer inCustomer) {
        return this.customerImplDB.createCustomer(inCustomer);
    }

    public Customer getCustomerByIdService(int customerId) {
        return this.customerImplDB.retrieveCustomerById(customerId);
    }

    public int updateCustomerByIdService(Customer inCustomer) {
        return this.customerImplDB.updateCustomerById(inCustomer);
    }

    public int delCustomerByIdService(int customerId) {
        return this.customerImplDB.deleteCustomerById(customerId);
    }
}