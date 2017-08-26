package us.supercheng.spring4.jdbc.transaction.xml.service;

public interface IOrderService {
    void buyBooksService(int userId, String isbn, int quantity);
}
