package us.supercheng.spring4.jdbc.transaction.xml.service.impl;


import us.supercheng.spring4.jdbc.transaction.xml.dao.impl.BookDaoImplDB;
import us.supercheng.spring4.jdbc.transaction.xml.entity.Book;
import us.supercheng.spring4.jdbc.transaction.xml.service.IBookService;
import us.supercheng.spring4.jdbc.transaction.xml.service.exception.BookServiceException;

public class BookServiceImplDB implements IBookService {

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