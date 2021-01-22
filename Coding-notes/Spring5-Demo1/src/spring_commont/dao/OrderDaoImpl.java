package spring_commont.dao;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Override
    public void buy() {
        System.out.println("buy 方法执行了");
    }
}
