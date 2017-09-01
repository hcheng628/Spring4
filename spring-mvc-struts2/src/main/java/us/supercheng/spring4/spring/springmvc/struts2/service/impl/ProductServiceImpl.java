package us.supercheng.spring4.spring.springmvc.struts2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.spring.springmvc.struts2.dao.IProductDao;
import us.supercheng.spring4.spring.springmvc.struts2.entity.Product;
import us.supercheng.spring4.spring.springmvc.struts2.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public ProductServiceImpl() {
        super();
    }

    public IProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(IProductDao productDao) {
        this.productDao = productDao;
    }

    public void checkProductService(Product product) {
        this.productDao.checkProduct(product);
    }
}