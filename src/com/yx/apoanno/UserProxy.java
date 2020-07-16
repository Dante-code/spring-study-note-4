package com.yx.apoanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect
@Order(3)
public class UserProxy {
//    相同切入点抽取
//    我的jdk与spring版本有冲突，使用@Pointcut会出错
    @Pointcut(value = "execution(* com.yx.apoanno.User.add(..))")
    public void pointdemo(){

    }


//    前置通知
//    @before注解表示作为前置通知

    @Before(value = "execution(* com.yx.apoanno.User.add(..))")
    public void before(){
        System.out.println("before......");
    }

//    最终通知
    @After(value = "execution(* com.yx.apoanno.User.add(..))")
    public void after(){
        System.out.println("after......");

    }

//  返回通知
    @AfterReturning(value = "execution(* com.yx.apoanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning......");
    }

    @AfterThrowing(value = "execution(* com.yx.apoanno.User.add(..))")
    public void AfterThrowing(){
        System.out.println("AfterThrowing......");
    }

    @Around(value = "execution(* com.yx.apoanno.User.add(..))")
    public void Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕之前......");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后......");
    }
}
