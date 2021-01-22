package com.spring5_aop_aspectJ.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect //生成代理对象
@Order(3) // 设置动态代理的优先级
public class UserProxy {
    @Pointcut(value = "execution(* com.spring5_aop_aspectJ.demo.User.add(..))")
    public void pointCut() {
    }

    //前置通知
    @Before(value = "pointCut()")
    public void before() {
        System.out.println("前置条件执行。。。。");
    }

    //后置通知
    @After(value = "pointCut()")
    public void after() {
        System.out.println("后置条件执行。。。。");
    }
}
