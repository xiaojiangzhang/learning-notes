package com.spring5_aop_aspectJ.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {
    @Pointcut(value = "execution(* com.spring5_aop_aspectJ.demo.User.add(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before() {
        System.out.println("PersonProxy 的前置方法执行");
    }

    @After(value = "pointCut()")
    public void after() {
        System.out.println("PersonProxy 的后置方法执行");
    }
}
