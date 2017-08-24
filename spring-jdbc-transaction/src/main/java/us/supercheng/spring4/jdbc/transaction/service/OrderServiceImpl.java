package us.supercheng.spring4.jdbc.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.jdbc.transaction.entity.Book;
import us.supercheng.spring4.jdbc.transaction.entity.Customer;

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
        // Check Book Count
        Book book = this.bookServiceImplDB.getBookByIsbnService(isbn);
        if (book.getCount() >= quantity) {
            double totalPrice = book.getPrice() * quantity;
            Customer customer = this.customerServiceImplDB.getCustomerByIdService(userId);
            if (customer.getBalance() >= totalPrice) {
                // Update Customer Balance and Book Count
                // Maybe Excetpion will occur below
                customer.setBalance(customer.getBalance() - totalPrice);
                book.setCount(book.getCount() - quantity);
                this.customerServiceImplDB.updateCustomerByIdService(customer);
                this.bookServiceImplDB.updateBookByIsbnService(book);
            } else {
                // User does not have enough money
            }
        } else {
            // Not Enough Books Left ;-(
        }
        // Check if User has Enough Money
        // Decrease Count and User Balance
    }
}