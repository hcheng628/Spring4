package us.supercheng.spring4.spring.hibernate.service;

import us.supercheng.spring4.spring.hibernate.entity.Customer;

public interface ICustomerService {
    int addCustomerService(Customer inCustomer);
    Customer getCustomerByIdService(int customerId);
    int updateCustomerByIdService(Customer inCustomer);
    int delCustomerByIdService(int customerId);

    int reduceUserBalanceById(int userId, double totalPrice);
}