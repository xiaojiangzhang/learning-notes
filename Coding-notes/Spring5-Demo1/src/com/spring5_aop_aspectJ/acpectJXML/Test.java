package com.spring5_aop_aspectJ.acpectJXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/spring5_aop_aspectJ/acpectJXML/bean.xml");
        Order order = (Order) context.getBean("order");
        order.buy();

    }
}
