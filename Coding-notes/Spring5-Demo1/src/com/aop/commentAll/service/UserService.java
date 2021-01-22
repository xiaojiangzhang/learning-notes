package com.aop.commentAll.service;

import com.aop.commentAll.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    //    注入对象
    @Autowired
    private UserDao userDao;

    public void execute() {
        userDao.updata();
        System.out.println();
    }
}
