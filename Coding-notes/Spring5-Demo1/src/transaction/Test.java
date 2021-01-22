package transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import transaction.service.UserService;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.count();

    }
}
