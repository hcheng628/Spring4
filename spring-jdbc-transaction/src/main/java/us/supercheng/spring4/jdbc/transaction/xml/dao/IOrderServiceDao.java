package us.supercheng.spring4.jdbc.transaction.xml.dao;

public interface IOrderServiceDao {
    void buyBooks(int userId, String isbn, int quantity);
}