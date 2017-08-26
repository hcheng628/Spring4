package us.supercheng.spring4.jdbc.transaction.annoation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import us.supercheng.spring4.jdbc.transaction.annoation.entity.Customer;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerImplDB implements ICustomerDao {

    private final String createCustomer_Query = "INSERT INTO Customer (id, username, balance) VALUES ( :id, :username, :balance);";
    private final String retrieveCustomerById_Query = "SELECT * FROM Customer WHERE id = :id";
    private final String updateCustomerById_Query = "UPDATE Customer SET username = :username, balance = :balance WHERE id = :id";
    private final String deleteCustomerById_Query = "DELETE FROM Customer WHERE id = :id";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CustomerImplDB() {
        super();
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public int createCustomer(Customer inCustomer) {
        return this.namedParameterJdbcTemplate.update(createCustomer_Query, this.setParam(inCustomer));
    }

    public Customer retrieveCustomerById(int inCustomerId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", inCustomerId);
        return this.namedParameterJdbcTemplate.query(retrieveCustomerById_Query, param, new Customer()).get(0);
    }

    public int updateCustomerById(Customer inCustomer) {
        return this.namedParameterJdbcTemplate.update(updateCustomerById_Query, this.setParam(inCustomer));
    }

    public int deleteCustomerById(int inCustomerId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", inCustomerId);
        return this.namedParameterJdbcTemplate.update(deleteCustomerById_Query, param);
    }

    private Map<String, Object> setParam(Customer inCustomer){
        System.out.println(inCustomer);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", inCustomer.getId());
        params.put("username", inCustomer.getUsername());
        params.put("balance", inCustomer.getBalance());
        return params;
    }
}