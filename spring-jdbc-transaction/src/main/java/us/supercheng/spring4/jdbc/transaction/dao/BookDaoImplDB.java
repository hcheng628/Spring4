package us.supercheng.spring4.jdbc.transaction.dao;

import us.supercheng.spring4.jdbc.transaction.entity.Book;

public class BookDaoImplDB implements IBookDao {
    public int createBook(Book inBook) {
        return 0;
    }

    public Book retrieveBookByIsbn(String inIsbn) {
        return null;
    }

    public int updateBookByIsbn(String inIsbn) {
        return 0;
    }

    public int deleteBookByIsbn(String inIsbn) {
        return 0;
    }
}