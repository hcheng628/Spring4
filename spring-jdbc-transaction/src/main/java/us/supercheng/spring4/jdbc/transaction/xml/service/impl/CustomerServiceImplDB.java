package us.supercheng.spring4.jdbc.transaction.xml.service.impl;


import us.supercheng.spring4.jdbc.transaction.xml.dao.impl.CustomerImplDB;
import us.supercheng.spring4.jdbc.transaction.xml.entity.Customer;
import us.supercheng.spring4.jdbc.transaction.xml.service.ICustomerService;
import us.supercheng.spring4.jdbc.transaction.xml.service.exception.CustomerServiceException;

public class CustomerServiceImplDB implements ICustomerService {

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

    public int reduceUserBalanceById(int userId, double totalPrice) {
        Customer customer = this.customerImplDB.retrieveCustomerById(userId);
        System.out.println("Total Price: " + totalPrice + " Total Balance: " + customer.getBalance());
        if (totalPrice <= customer.getBalance()) {
            customer.setBalance(customer.getBalance() - totalPrice);
            this.customerImplDB.updateCustomerById(customer);
        } else {
            throw new CustomerServiceException("Insufficient Fund");
        }
        return 1;
    }
}