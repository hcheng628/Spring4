package us.supercheng.spring4.jdbc.transaction.xml.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import us.supercheng.spring4.jdbc.transaction.annoation.dao.IBookDao;
import us.supercheng.spring4.jdbc.transaction.annoation.entity.Book;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookDaoImplDB implements IBookDao {

    private final String createBook_Query = "INSERT INTO Book (id, isbn, name, price, count) VALUES (:id, :isbn, :name, :price, :count);";
    private final String retrieveBookByIsbn_Query = "SELECT * FROM Book WHERE isbn = :isbn;";
    private final String updateBookByIsbn_Query = "UPDATE Book SET id = :id, name = :name, price = :price, count = :count WHERE isbn =:isbn;";
    private final String deleteBookByIsbn_Query = "DELETE FROM Book WHERE isbn =:isbn;";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookDaoImplDB() {
        super();
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public int createBook(Book inBook) {
        return this.namedParameterJdbcTemplate.update(createBook_Query, this.setParam(inBook));
    }

    public Book retrieveBookByIsbn(String inIsbn) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("isbn", inIsbn);
        return this.namedParameterJdbcTemplate.query(retrieveBookByIsbn_Query, param, new Book()).get(0);
    }

    public int updateBookByIsbn(Book inBook) {
        return this.namedParameterJdbcTemplate.update(updateBookByIsbn_Query, this.setParam(inBook));
    }

    public int deleteBookByIsbn(String inIsbn) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("isbn", inIsbn);
        return this.namedParameterJdbcTemplate.update(deleteBookByIsbn_Query, param);
    }

    private Map<String, Object> setParam(Book inBook) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", inBook.getId());
        param.put("isbn", inBook.getIsbn());
        param.put("name", inBook.getName());
        param.put("price", inBook.getPrice());
        param.put("count", inBook.getCount());
        return param;
    }
}