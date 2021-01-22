package spring_commont.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_commont.SpringConifg;
import spring_commont.service.OrderService;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConifg.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.execute();
    }
}
