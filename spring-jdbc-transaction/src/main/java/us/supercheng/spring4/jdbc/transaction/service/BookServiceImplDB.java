package us.supercheng.spring4.jdbc.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.jdbc.transaction.dao.BookDaoImplDB;
import us.supercheng.spring4.jdbc.transaction.entity.Book;

@Service
public class BookServiceImplDB implements IBookService{

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
}