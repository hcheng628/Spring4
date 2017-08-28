package us.supercheng.spring4.spring.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.supercheng.spring4.spring.hibernate.dao.ICustomerDao;
import us.supercheng.spring4.spring.hibernate.entity.Customer;

@Repository
public class CustomerDaoImplHibernate implements ICustomerDao {

    private final String createCustomer_Query = "INSERT INTO Customer (id, username, balance) VALUES ( :id, :username, :balance);";
    private final String retrieveCustomerById_Query = "FROM Customer c WHERE c.id = :id";
    private final String updateCustomerById_Query = "UPDATE Customer SET username = :username, balance = :balance WHERE id = :id";
    private final String deleteCustomerById_Query = "DELETE FROM Customer WHERE id = :id";

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int createCustomer(Customer inCustomer) {
        this.sessionFactory.getCurrentSession().save(inCustomer);
        return 1;
    }

    public Customer retrieveCustomerById(int inCustomerId) {
        return (Customer) this.sessionFactory.getCurrentSession().createQuery(retrieveCustomerById_Query).setString("id", inCustomerId + "").list().get(0);
    }

    public int updateCustomerById(Customer inCustomer) {
        this.sessionFactory.getCurrentSession().update(inCustomer);
        return 1;
    }

    public int deleteCustomerById(int inCustomerId) {
        Customer customer = new Customer();
        customer.setId(inCustomerId);
        this.sessionFactory.getCurrentSession().delete(customer);
        return 1;
    }
}
