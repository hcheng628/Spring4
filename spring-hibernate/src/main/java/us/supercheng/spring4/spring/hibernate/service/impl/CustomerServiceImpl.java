package us.supercheng.spring4.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.spring.hibernate.dao.ICustomerDao;
import us.supercheng.spring4.spring.hibernate.dao.impl.CustomerImplDB;
import us.supercheng.spring4.spring.hibernate.entity.Customer;
import us.supercheng.spring4.spring.hibernate.service.ICustomerService;
import us.supercheng.spring4.spring.hibernate.service.exception.CustomerServiceException;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDDaoImplHibernate;

    public ICustomerDao getCustomerImplDB() {
        return customerDDaoImplHibernate;
    }

    public void setCustomerImplDB(CustomerImplDB customerImplDB) {
        this.customerDDaoImplHibernate = customerImplDB;
    }

    public int addCustomerService(Customer inCustomer) {
        return this.customerDDaoImplHibernate.createCustomer(inCustomer);
    }

    public Customer getCustomerByIdService(int customerId) {
        return this.customerDDaoImplHibernate.retrieveCustomerById(customerId);
    }

    public int updateCustomerByIdService(Customer inCustomer) {
        return this.customerDDaoImplHibernate.updateCustomerById(inCustomer);
    }

    public int delCustomerByIdService(int customerId) {
        return this.customerDDaoImplHibernate.deleteCustomerById(customerId);
    }

    public int reduceUserBalanceById(int userId, double totalPrice) {
        Customer customer = this.customerDDaoImplHibernate.retrieveCustomerById(userId);
        System.out.println("Total Price: " + totalPrice + " Total Balance: " + customer.getBalance());
        if (totalPrice <= customer.getBalance()) {
            customer.setBalance(customer.getBalance() - totalPrice);
            this.customerDDaoImplHibernate.updateCustomerById(customer);
        } else {
            throw new CustomerServiceException("Insufficient Fund");
        }
        return 1;
    }
}