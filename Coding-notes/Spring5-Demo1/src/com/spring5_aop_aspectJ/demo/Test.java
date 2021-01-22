package com.spring5_aop_aspectJ.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/spring5_aop_aspectJ/bean.xml");
        User user = (User) context.getBean("user");
        user.add();
    }
}
