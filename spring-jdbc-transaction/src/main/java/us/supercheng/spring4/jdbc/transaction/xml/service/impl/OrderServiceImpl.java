package us.supercheng.spring4.jdbc.transaction.xml.service.impl;


import us.supercheng.spring4.jdbc.transaction.xml.dao.impl.OrderServiceDaoImpl;
import us.supercheng.spring4.jdbc.transaction.xml.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

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

    public void buyBooksService(int userId, String isbn, int quantity) {
        this.orderServiceDao.buyBooks(userId, isbn, quantity);
    }
}