package com.xiaojiang.testDemo;

import com.xiaojiang.bean.Dep;
import com.xiaojiang.bean.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp.toString());
    }
}
