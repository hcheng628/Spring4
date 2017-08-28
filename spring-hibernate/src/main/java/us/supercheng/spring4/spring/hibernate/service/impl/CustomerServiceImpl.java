package us.supercheng.spring4.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.spring.hibernate.dao.ICustomerDao;
import us.supercheng.spring4.spring.hibernate.entity.Customer;
import us.supercheng.spring4.spring.hibernate.service.ICustomerService;
import us.supercheng.spring4.spring.hibernate.service.exception.CustomerServiceException;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDaoImplHibernate;

    public ICustomerDao getCustomerImplDB() {
        return this.customerDaoImplHibernate;
    }

    public void setCustomerImplDB(ICustomerDao customerImplDB) {
        this.customerDaoImplHibernate = customerImplDB;
    }

    public int addCustomerService(Customer inCustomer) {
        return this.customerDaoImplHibernate.createCustomer(inCustomer);
    }

    public Customer getCustomerByIdService(int customerId) {
        return this.customerDaoImplHibernate.retrieveCustomerById(customerId);
    }

    public int updateCustomerByIdService(Customer inCustomer) {
        return this.customerDaoImplHibernate.updateCustomerById(inCustomer);
    }

    public int delCustomerByIdService(int customerId) {
        return this.customerDaoImplHibernate.deleteCustomerById(customerId);
    }

    public int reduceUserBalanceById(int userId, double totalPrice) {
        Customer customer = this.customerDaoImplHibernate.retrieveCustomerById(userId);
        System.out.println("Total Price: " + totalPrice + " Total Balance: " + customer.getBalance());
        if (totalPrice <= customer.getBalance()) {
            customer.setBalance(customer.getBalance() - totalPrice);
            this.customerDaoImplHibernate.updateCustomerById(customer);
        } else {
            throw new CustomerServiceException("Insufficient Fund");
        }
        return 1;
    }
}