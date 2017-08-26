package us.supercheng.spring4.jdbc.transaction.xml.dao;

import us.supercheng.spring4.jdbc.transaction.annoation.entity.Book;

public interface IBookDao {
    int createBook(Book inBook);
    Book retrieveBookByIsbn(String inIsbn);
    int updateBookByIsbn(Book inBook);
    int deleteBookByIsbn(String inIsbn);
}