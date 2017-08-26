package us.supercheng.spring4.jdbc.transaction.xml.dao.impl;


import us.supercheng.spring4.jdbc.transaction.xml.dao.IOrderServiceDao;
import us.supercheng.spring4.jdbc.transaction.xml.entity.Book;
import us.supercheng.spring4.jdbc.transaction.xml.service.impl.BookServiceImplDB;
import us.supercheng.spring4.jdbc.transaction.xml.service.impl.CustomerServiceImplDB;

public class OrderServiceDaoImpl implements IOrderServiceDao {

    private CustomerServiceImplDB customerServiceImplDB;
    private BookServiceImplDB bookServiceImplDB;

    public OrderServiceDaoImpl () {
        super();
    }

    public CustomerServiceImplDB getCustomerServiceImplDB() {
        return customerServiceImplDB;
    }

    public void setCustomerServiceImplDB(CustomerServiceImplDB customerServiceImplDB) {
        this.customerServiceImplDB = customerServiceImplDB;
    }

    public BookServiceImplDB getBookServiceImplDB() {
        return bookServiceImplDB;
    }

    public void setBookServiceImplDB(BookServiceImplDB bookServiceImplDB) {
        this.bookServiceImplDB = bookServiceImplDB;
    }

    public void buyBooks(int userId, String isbn, int quantity) {
        Book book = this.bookServiceImplDB.getBookByIsbnService(isbn);
        this.bookServiceImplDB.reduceBookCountByIsbn(book, quantity);
        double totalPrice = book.getPrice() * quantity;
        this.customerServiceImplDB.reduceUserBalanceById(userId, totalPrice);
    }
}
