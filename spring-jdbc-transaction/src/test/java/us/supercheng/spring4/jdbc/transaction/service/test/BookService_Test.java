package us.supercheng.spring4.jdbc.transaction.service.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.supercheng.spring4.jdbc.transaction.entity.Book;
import us.supercheng.spring4.jdbc.transaction.service.BookServiceImplDB;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookService_Test {
    ApplicationContext appContext;
    BookServiceImplDB bookServiceImplDB;

    @Before
    public void warmUp() {
        this.appContext = new ClassPathXmlApplicationContext("Spring-IoC-Config.xml");
        this.bookServiceImplDB = (BookServiceImplDB) this.appContext.getBean("bookServiceImplDB");
        System.out.println(this.bookServiceImplDB);
    }

    @Test
    public void a_add_Book_Service_Test() {
        Book book = new Book();
        book.setId(3);
        book.setIsbn("cheng-hong-yu");
        book.setName("Test");
        book.setPrice(66.6);
        book.setCount(66);
        System.out.println(this.bookServiceImplDB.addBookService(book));
    }

    @Test
    public void b_get_BookByIsbn_Service_Test() {
        System.out.println(this.bookServiceImplDB.getBookByIsbnService("cheng-hong-yu"));
    }

    @Test
    public void c_update_BookByIsbn_Service_Test() {
        Book book = new Book();
        book.setId(3);
        book.setIsbn("cheng-hong-yu");
        book.setName("Test Update");
        book.setPrice(66.6);
        book.setCount(66);
        System.out.println(this.bookServiceImplDB.updateBookByIsbnService(book));

    }

    @Test
    public void d_delBookByIsbn_Service_Test() {
        System.out.println(this.bookServiceImplDB.delBookByIsbnService("cheng-hong-yu"));
    }
}