package us.supercheng.spring4.jdbc.transaction.dao;

import us.supercheng.spring4.jdbc.transaction.entity.Book;

public interface IBookDao {
    int createBook(Book inBook);
    Book retrieveBookByIsbn(String inIsbn);
    int updateBookByIsbn(String inIsbn);
    int deleteBookByIsbn(String inIsbn);
}