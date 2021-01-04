package com.xiaojiang.java.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestRefelection {
    public static void main(String[] args) throws ClassNotFoundException {
//        第一种方式获取class对象
        Persion persion1 = new Persion();
        Class class_persion1 = persion1.getClass();
        System.out.println(class_persion1.getName());

//        第二种方式获取class对象
        Persion persion2 = new Persion();
        Class class_persion2 = Persion.class;
        System.out.println(class_persion1 == class_persion2);

//        第三种方式获取class对象
        Class class_persion3 = Class.forName("com.bean.Persion");//此路径必须是真实路径，就是带包名的类路径
        System.out.println(class_persion1 == class_persion3);

//        获取Persion类的所有方法信息
        Method[] declaredMethods = class_persion1.getDeclaredMethods();
        for (Method m: declaredMethods){
            System.out.println(m);
        }

//        获取Persion类的所有成员属性信息
        Field[] declaredFields = class_persion1.getDeclaredFields();
        for (Field f: declaredFields){
            System.out.println(f);
        }

//        使用反射创建对象
        try {
            Persion reflection = (Persion) class_persion1.newInstance();
            System.out.println(reflection.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

class Persion{
    String name;
    String age;
    String sex;

    public String getName(){
        return this.name;
    }

    public String getAge(){
        return this.age;
    }

    public String sex(){
        return this.sex;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}