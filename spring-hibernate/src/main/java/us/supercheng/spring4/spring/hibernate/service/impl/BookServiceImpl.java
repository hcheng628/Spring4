package us.supercheng.spring4.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.supercheng.spring4.spring.hibernate.dao.IBookDao;
import us.supercheng.spring4.spring.hibernate.entity.Book;
import us.supercheng.spring4.spring.hibernate.service.IBookService;
import us.supercheng.spring4.spring.hibernate.service.exception.BookServiceException;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDaoImplHibernate;

    public BookServiceImpl() {
        super();
    }

    public IBookDao getBookDaoImplDB() {
        return bookDaoImplHibernate;
    }

    public void setBookDaoImplDB(IBookDao bookDaoImplDB) {
        this.bookDaoImplHibernate = bookDaoImplDB;
    }

    public int addBookService(Book inBook) {
        return this.bookDaoImplHibernate.createBook(inBook);
    }

    public Book getBookByIsbnService(String inIsbn) {
        return this.bookDaoImplHibernate.retrieveBookByIsbn(inIsbn);
    }

    public int updateBookByIsbnService(Book inBook) {
        return this.bookDaoImplHibernate.updateBookByIsbn(inBook);
    }

    public int delBookByIsbnService(String inIsbn) {
        return this.bookDaoImplHibernate.deleteBookByIsbn(inIsbn);
    }

    public int reduceBookCountByIsbn(Book inBook, int inCount) {
        Book book = this.bookDaoImplHibernate.retrieveBookByIsbn(inBook.getIsbn());
        System.out.println("Buy Count: " + inCount + " Inventory Count: " + book.getCount());
        if (inCount <= book.getCount()) {
            book.setCount(book.getCount()- inCount);
            this.bookDaoImplHibernate.updateBookByIsbn(book);
        } else {
            throw new BookServiceException("Insufficient Inventory");
        }
        return 1;
    }
}