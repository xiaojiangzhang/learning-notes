package transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transaction.dao.UserDao;


@Transactional//添加事务
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void count() {

        userDao.cutMarry();
//        int a = 100 / 0;
        userDao.addLucy();


    }
}
