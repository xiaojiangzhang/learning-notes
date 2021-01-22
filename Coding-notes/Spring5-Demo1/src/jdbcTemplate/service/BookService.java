package jdbcTemplate.service;

import jdbcTemplate.bean.Book;
import jdbcTemplate.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void findBookInfor(int id) {
        Book bookInf = bookDao.findBookInf(2);
        System.out.println(bookInf);
    }

    public void findAll() {
        List<Book> all = bookDao.findAll();
        System.out.println(Arrays.toString(new List[]{all}));
    }
}
