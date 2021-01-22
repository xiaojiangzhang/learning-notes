package com.aop.commentAll.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {
    @Pointcut(value = "execution(* com.aop.commentAll.dao.UserDao.updata(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before() {
        System.out.println("前置方法被执行");
    }
}
