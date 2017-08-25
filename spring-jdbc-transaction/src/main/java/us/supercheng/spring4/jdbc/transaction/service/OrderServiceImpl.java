package us.supercheng.spring4.jdbc.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.jdbc.transaction.entity.Book;
import us.supercheng.spring4.jdbc.transaction.entity.Customer;
import us.supercheng.spring4.jdbc.transaction.service.exception.BookServiceException;
import us.supercheng.spring4.jdbc.transaction.service.exception.CustomerServiceException;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private CustomerServiceImplDB customerServiceImplDB;
    @Autowired
    private BookServiceImplDB bookServiceImplDB;

    public OrderServiceImpl () {
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

    public void buyBooksService(int userId, String isbn, int quantity) {
        Book book = this.bookServiceImplDB.getBookByIsbnService(isbn);
        this.bookServiceImplDB.reduceBookCountByIsbn(book, quantity);
        double totalPrice = book.getPrice() * quantity;
        this.customerServiceImplDB.reduceUserBalanceById(userId, totalPrice);
    }
}