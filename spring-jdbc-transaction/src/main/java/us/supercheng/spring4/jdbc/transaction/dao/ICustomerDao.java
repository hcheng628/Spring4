package us.supercheng.spring4.jdbc.transaction.dao;

import us.supercheng.spring4.jdbc.transaction.entity.Customer;

public interface ICustomerDao {
    int createCustomer(Customer inCustomer);
    Customer retrieveCustomerById(int inCustomerId);
    int updateCustomerById(Customer inCustomer);
    int deleteCustomerById(int inCustomerId);
}