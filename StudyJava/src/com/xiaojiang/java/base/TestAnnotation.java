package com.xiaojiang.java.base;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface MyTestAnnotation{
    String name() default "xiaojiang";
    int age() default 25;
}

@MyTestAnnotation(name = "dajiang", age = 99)
class Father{

}
class Son extends Father{

}
public class TestAnnotation {
    public static void main(String[] args) {
        Class<Father> sonClass = Father.class;
        MyTestAnnotation annotation = sonClass.getAnnotation(MyTestAnnotation.class);
        System.out.println(annotation.name());
        System.out.println(annotation.age());


    }
}