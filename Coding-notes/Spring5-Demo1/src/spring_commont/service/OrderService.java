package spring_commont.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_commont.dao.OrderDao;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public void execute() {
        orderDao.buy();
        System.out.println("execute方法执行了");
    }
}
