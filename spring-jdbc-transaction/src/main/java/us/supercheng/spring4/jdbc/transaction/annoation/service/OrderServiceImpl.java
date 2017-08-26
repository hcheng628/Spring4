package us.supercheng.spring4.jdbc.transaction.annoation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.supercheng.spring4.jdbc.transaction.annoation.dao.OrderServiceDaoImpl;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderServiceDaoImpl orderServiceDao;

    public OrderServiceImpl () {
        super();
    }

    public OrderServiceDaoImpl getOrderServiceDao() {
        return orderServiceDao;
    }

    public void setOrderServiceDao(OrderServiceDaoImpl orderServiceDao) {
        this.orderServiceDao = orderServiceDao;
    }

    @Transactional
    public void buyBooksService(int userId, String isbn, int quantity) {
        this.orderServiceDao.buyBooks(userId, isbn, quantity);
    }
}