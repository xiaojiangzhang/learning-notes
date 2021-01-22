package com.aop.commentAll.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void updata() {
        System.out.println("updata方法被执行了。。。。");
    }
}
