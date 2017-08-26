package us.supercheng.spring4.jdbc.transaction.dao;

public interface IOrderServiceDao {
    void buyBooks(int userId, String isbn, int quantity);
}