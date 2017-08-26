package us.supercheng.spring4.jdbc.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import us.supercheng.spring4.jdbc.transaction.entity.Book;
import us.supercheng.spring4.jdbc.transaction.service.BookServiceImplDB;
import us.supercheng.spring4.jdbc.transaction.service.CustomerServiceImplDB;

@Repository
public class OrderServiceDaoImpl implements IOrderServiceDao {

    @Autowired
    private CustomerServiceImplDB customerServiceImplDB;
    @Autowired
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
