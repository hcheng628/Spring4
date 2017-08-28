package us.supercheng.spring4.spring.hibernate.service;

public interface IOrderService {
    void buyBooksService(int userId, String isbn, int quantity);
}
