package us.supercheng.spring4.spring.hibernate.dao;

import us.supercheng.spring4.spring.hibernate.entity.Book;

public interface IBookDao {
    int createBook(Book inBook);
    Book retrieveBookByIsbn(String inIsbn);
    int updateBookByIsbn(Book inBook);
    int deleteBookByIsbn(String inIsbn);
}