package com.yx.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.yx"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {

}
