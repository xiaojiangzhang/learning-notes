package com.aop.dao.test;

import com.aop.dao.UserDao;
import com.aop.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/*
 * 使用java动态代理实现AOP
 *1 定义UserDao接口，实现UserDao实现类
 *2 使用JDK中Proxy类中的newProxyInstance方法创建UserDao的动态代理类
 *  newProxyInstance方法需要三个参数：
 *      第一参数，类加载器
 *      第二参数，增强方法所在的类，这个类实现的接口，支持多个接口
 *      第三参数，实现这个接口 InvocationHandler，创建代理对象，写增强的部分
 *3 实现InvocationHandler接口：
 *      实现InvocationHandler接口中的invoke方法，invoke方法中有三个参数：
 *      参数1：Object proxy,
 *      参数2：Method method, 增强方法的名称
 *      参数3：Object[] args,需要增强方法的参数
 *
 *
 * */
public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        UserDao userDao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),
                interfaces, new Invocat(new UserDaoImpl()));
        int add = userDao.add(1, 2);
        System.out.println("result:" + add);
    }
}

class Invocat implements InvocationHandler {
    private Object obj;

    public Invocat(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        可以通过method.getname() 判断不同的方法名称，从而实现对不同方法的增强
//        这里添加需要在原方法执行之前的代码
        System.out.println("执行方法之前。。。" + method.getName() + ",参数：" + Arrays.toString(args));

        Object invoke = method.invoke(obj, args);
//        这里添加需要在原方法执行之后增强的代码
        System.out.println("执行方法之后。。。" + method.getName() + "，参数：" + Arrays.toString(args));
        return invoke;
    }
}
