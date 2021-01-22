package com.aop.dao;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行。。。。");
        return a + b;
    }
}
