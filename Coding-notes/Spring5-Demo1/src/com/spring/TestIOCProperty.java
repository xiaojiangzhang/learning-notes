package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOCProperty {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Student student = context.getBean("student", Student.class);
        Student student1 = context.getBean("student", Student.class);
        System.out.println(student1);
        System.out.println(student);
    }
}
