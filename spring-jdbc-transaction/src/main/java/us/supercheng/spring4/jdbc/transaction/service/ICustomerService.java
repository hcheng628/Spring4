package us.supercheng.spring4.jdbc.transaction.service;

import us.supercheng.spring4.jdbc.transaction.entity.Customer;

public interface ICustomerService {
    int addCustomerService(Customer inCustomer);
    Customer getCustomerByIdService(int customerId);
    int updateCustomerByIdService(Customer inCustomer);
    int delCustomerByIdService(int customerId);
}