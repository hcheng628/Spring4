package us.supercheng.spring4.spring.hibernate.service.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.spring.hibernate.entity.Book;
import us.supercheng.spring4.spring.hibernate.service.impl.BookServiceImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookServiceHibernate_Test {

    final String test_isbn = "isbn-test-abc-123";

    private ApplicationContext applicationContext;
    private BookServiceImpl bookServiceImplDB;

    {
        this.applicationContext = new ClassPathXmlApplicationContext("Spring-AoP-Config.xml");
        this.bookServiceImplDB = this.applicationContext.getBean(BookServiceImpl.class);
    }

    @Test
    public void a_createBook_Service_Test () {
        Book book = new Book();
        book.setId(111);
        book.setName("0");
        book.setIsbn(test_isbn);
        book.setPrice(55.55);
        book.setCount(3000);
        this.bookServiceImplDB.addBookService(book);
    }

    @Test
    public void b_retrieveBookByIsbn_Service_Test () {
        System.out.println(this.bookServiceImplDB.getBookByIsbnService(test_isbn));
    }

    @Test
    public void c_updateBookByIsbn_Service_Test () {
        Book book = new Book();
        book.setId(111);
        book.setName("UpdateHibernate");
        book.setIsbn(test_isbn);
        book.setPrice(55.55);
        book.setCount(10);
        System.out.println(this.bookServiceImplDB.updateBookByIsbnService(book));
    }

    @Test
    public void d_deleteBookByIsbn_Service_Test () {
        System.out.println(this.bookServiceImplDB.delBookByIsbnService(test_isbn));
    }
}