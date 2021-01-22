package com.xiaojiang.service;

import com.xiaojiang.dao.UserDao;
import com.xiaojiang.dao.UserDaoImpl;

public class UserService {
    //创建UserDao对应的属性   生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add ......");
//        1原始方式：创建userDao对象
//        UserDao userDao = new UserDaoImpl();
//        userDao.upData();
        //2 将userDao注入
        userDao.upData();
    }
}
