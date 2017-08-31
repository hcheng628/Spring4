package us.supercheng.spring4.spring.struts2.dao.impl;

import org.springframework.stereotype.Repository;
import us.supercheng.spring4.spring.struts2.dao.IProductDao;
import us.supercheng.spring4.spring.struts2.entity.Product;

@Repository
public class ProductDaoImpl implements IProductDao {

    public ProductDaoImpl() {
        super();
    }

    public void checkProduct(Product product) {
        System.out.println(product.toString());
    }
}