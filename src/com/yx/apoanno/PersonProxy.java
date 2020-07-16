package com.yx.apoanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.yx.apoanno.User.add(..))")
    public void before(){
        System.out.println("PersonProxy before......");
    }

    @After(value = "execution(* com.yx.apoanno.User.add(..))")
    public void after(){
        System.out.println("PersonProxy after......");
    }

    @Around(value = "execution(* com.yx.apoanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("PersonProxy 环绕之前......");
        proceedingJoinPoint.proceed();
        System.out.println("PersonProxy 环绕之后......");
    }
}
