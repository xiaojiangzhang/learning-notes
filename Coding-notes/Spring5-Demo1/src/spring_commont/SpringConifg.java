package spring_commont;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
//配置扫描注解
@ComponentScan(value = {"spring_commont"})
//配置动态代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConifg {
}
