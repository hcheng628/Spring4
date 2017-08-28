package us.supercheng.spring4.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.spring.hibernate.entity.Book;
import us.supercheng.spring4.spring.hibernate.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private CustomerServiceImpl customerServiceImplDB;

    @Autowired
    private BookServiceImpl bookServiceImplDB;

    public OrderServiceImpl () {
        super();
    }

    public CustomerServiceImpl getCustomerServiceImplDB() {
        return customerServiceImplDB;
    }

    public void setCustomerServiceImplDB(CustomerServiceImpl customerServiceImplDB) {
        this.customerServiceImplDB = customerServiceImplDB;
    }

    public BookServiceImpl getBookServiceImplDB() {
        return bookServiceImplDB;
    }

    public void setBookServiceImplDB(BookServiceImpl bookServiceImplDB) {
        this.bookServiceImplDB = bookServiceImplDB;
    }

    public void buyBooksService(int userId, String isbn, int quantity) {
        Book book = this.bookServiceImplDB.getBookByIsbnService(isbn);
        this.bookServiceImplDB.reduceBookCountByIsbn(book, quantity);
        double totalPrice = book.getPrice() * quantity;
        this.customerServiceImplDB.reduceUserBalanceById(userId, totalPrice);
    }
}