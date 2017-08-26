package us.supercheng.spring4.jdbc.transaction.annoation.service;

import us.supercheng.spring4.jdbc.transaction.annoation.entity.Book;

public interface IBookService {
    int addBookService(Book inBook);
    Book getBookByIsbnService(String inIsbn);
    int updateBookByIsbnService(Book inBook);
    int delBookByIsbnService(String inIsbn);

    int reduceBookCountByIsbn(Book inBook, int inCount);
}