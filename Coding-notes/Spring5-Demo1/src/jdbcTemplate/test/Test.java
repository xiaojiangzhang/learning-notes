package jdbcTemplate.test;

import jdbcTemplate.bean.Book;
import jdbcTemplate.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/jdbcTemplate/beans.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //插入测试
//        Book book = new Book();
//        book.setId(1092);
//        book.setName("荷塘月色");
//        book.setContext("荷塘倒影着月色");
//        bookService.addBook(book);
        //查询返回对象
        bookService.findBookInfor(1);
        //查询返回list集合
        bookService.findAll();

    }
}
