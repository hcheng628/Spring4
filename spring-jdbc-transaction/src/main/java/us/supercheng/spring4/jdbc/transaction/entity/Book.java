package us.supercheng.spring4.jdbc.transaction.entity;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book implements RowMapper {

    private int id;
    private String isbn;
    private String name;
    private double price;
    private int count;

    public Book() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setName(resultSet.getString("name"));
        book.setPrice(resultSet.getDouble("price"));
        book.setCount(resultSet.getInt("count"));
        return book;
    }
}