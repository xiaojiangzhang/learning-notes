package jdbcTemplate.dao;

import jdbcTemplate.bean.Book;

import java.util.List;

public interface BookDao {
    public void add(Book book);

    public Book findBookInf(int id);

    public List<Book> findAll();
}
