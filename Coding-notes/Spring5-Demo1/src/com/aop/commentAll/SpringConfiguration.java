package com.aop.commentAll;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Configuration;

//完全注解开发配置
@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"com.aop.commentAll"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfiguration {

}
