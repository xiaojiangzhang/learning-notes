package com.spring5_aop_aspectJ.demo;

import org.springframework.stereotype.Component;

@Component
public class User {
    public void add() {
        System.out.println("add......方法执行");
    }
}
