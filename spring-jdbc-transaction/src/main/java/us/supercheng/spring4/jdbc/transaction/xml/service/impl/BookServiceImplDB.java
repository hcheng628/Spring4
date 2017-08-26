package us.supercheng.spring4.jdbc.transaction.xml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.jdbc.transaction.annoation.dao.BookDaoImplDB;
import us.supercheng.spring4.jdbc.transaction.annoation.entity.Book;
import us.supercheng.spring4.jdbc.transaction.annoation.service.IBookService;
import us.supercheng.spring4.jdbc.transaction.annoation.service.exception.BookServiceException;

@Service
public class BookServiceImplDB implements IBookService {

    @Autowired
    private BookDaoImplDB bookDaoImplDB;

    public BookServiceImplDB() {
        super();
    }

    public BookDaoImplDB getBookDaoImplDB() {
        return bookDaoImplDB;
    }

    public void setBookDaoImplDB(BookDaoImplDB bookDaoImplDB) {
        this.bookDaoImplDB = bookDaoImplDB;
    }

    public int addBookService(Book inBook) {
        return this.bookDaoImplDB.createBook(inBook);
    }

    public Book getBookByIsbnService(String inIsbn) {
        return this.bookDaoImplDB.retrieveBookByIsbn(inIsbn);
    }

    public int updateBookByIsbnService(Book inBook) {
        return this.bookDaoImplDB.updateBookByIsbn(inBook);
    }

    public int delBookByIsbnService(String inIsbn) {
        return this.bookDaoImplDB.deleteBookByIsbn(inIsbn);
    }

    public int reduceBookCountByIsbn(Book inBook, int inCount) {
        Book book = this.bookDaoImplDB.retrieveBookByIsbn(inBook.getIsbn());
        System.out.println("Buy Count: " + inCount + " Inventory Count: " + book.getCount());
        if (inCount <= book.getCount()) {
            book.setCount(book.getCount()- inCount);
            this.bookDaoImplDB.updateBookByIsbn(book);
        } else {
            throw new BookServiceException("Insufficient Inventory");
        }
        return 1;
    }
}