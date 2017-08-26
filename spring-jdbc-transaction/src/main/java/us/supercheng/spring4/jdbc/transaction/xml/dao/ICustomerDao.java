package us.supercheng.spring4.jdbc.transaction.xml.dao;

import us.supercheng.spring4.jdbc.transaction.annoation.entity.Customer;

public interface ICustomerDao {
    int createCustomer(Customer inCustomer);
    Customer retrieveCustomerById(int inCustomerId);
    int updateCustomerById(Customer inCustomer);
    int deleteCustomerById(int inCustomerId);
}