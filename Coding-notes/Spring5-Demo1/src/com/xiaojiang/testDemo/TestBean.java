package com.xiaojiang.testDemo;

import com.xiaojiang.Book;
import com.xiaojiang.Order;
import com.xiaojiang.Students;
import com.xiaojiang.User;
import com.xiaojiang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    public static void main(String[] args) {
        /*
         * 使用Spring IOC创建对象  通过ApplicationContext类创建bean ApplicationContext在声明时就将bean文件中的所有对象进行创建
         * */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./bean2.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.add();


    }
}
