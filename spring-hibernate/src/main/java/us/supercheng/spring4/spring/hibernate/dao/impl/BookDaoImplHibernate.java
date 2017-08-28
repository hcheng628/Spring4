package us.supercheng.spring4.spring.hibernate.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.supercheng.spring4.spring.hibernate.dao.IBookDao;
import us.supercheng.spring4.spring.hibernate.entity.Book;

@Repository
public class BookDaoImplHibernate implements IBookDao {

    private final String retrieveBookByIsbn_Query = "FROM Book b WHERE b.isbn = :isbn";
    private final String updateBookByIsbn_Query = "UPDATE Book SET id = :id, name = :name, price = :price, count = :count WHERE isbn =:isbn;";
    private final String deleteBookByIsbn_Query = "DELETE FROM Book WHERE isbn =:isbn;";

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int createBook(Book inBook) {
        this.sessionFactory.getCurrentSession().save(inBook);
        return 1;
    }

    public Book retrieveBookByIsbn(String inIsbn) {
        return (Book) this.sessionFactory.getCurrentSession().createQuery(retrieveBookByIsbn_Query).setString("isbn", inIsbn).list().get(0);
    }

    public int updateBookByIsbn(Book inBook) {
        this.sessionFactory.getCurrentSession().update(inBook);
        return 1;
    }

    public int deleteBookByIsbn(String inIsbn) {
        Book book = new Book();
        book.setIsbn(inIsbn);
        this.sessionFactory.getCurrentSession().delete(book);
        return 1;
    }
}
