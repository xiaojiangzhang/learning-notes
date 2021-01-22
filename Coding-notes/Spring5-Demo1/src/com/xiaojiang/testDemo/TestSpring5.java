package com.xiaojiang.testDemo;

import com.xiaojiang.Book;
import com.xiaojiang.Order;
import com.xiaojiang.Students;
import com.xiaojiang.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {
    public static void main(String[] args) {
        /*
         * 使用Spring IOC创建对象  通过ApplicationContext类创建bean ApplicationContext在声明时就将bean文件中的所有对象进行创建
         * */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./bean1.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.toString());
        //1 无参构造方法注入属性值，通过property注入
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book.toString());
        //2 有参构造方法注入   通过使用constructor-arg进行注入
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println(order.toString());
//        通过set方法注入属性值
        Students student = applicationContext.getBean("student", Students.class);
        System.out.println(student.toString());

    }
}
