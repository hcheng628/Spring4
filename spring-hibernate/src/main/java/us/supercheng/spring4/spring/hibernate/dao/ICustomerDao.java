package us.supercheng.spring4.spring.hibernate.dao;

import us.supercheng.spring4.spring.hibernate.entity.Customer;

public interface ICustomerDao {
    int createCustomer(Customer inCustomer);
    Customer retrieveCustomerById(int inCustomerId);
    int updateCustomerById(Customer inCustomer);
    int deleteCustomerById(int inCustomerId);
}