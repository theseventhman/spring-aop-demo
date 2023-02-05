package com.tj.exercise.springaopdemo.util;

import com.tj.exercise.springaopdemo.interview.AopTestDemo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author: tj
 * @Date: 2023/2/4 23:05
 */
@Aspect
@Component
public class LogUtil {

    @Pointcut("execution(public * com.tj.exercise.springaopdemo.interview..*.*(..))")
    public void pctMethod(){
    }

    @Around(value = "pctMethod()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object ret = proceedingJoinPoint.proceed();
        System.out.println("Around advice");
        return  ret;
    }

    @Before("pctMethod()")
    public void before(){
        System.out.println("Before advice");
    }

    @After("pctMethod()")
    public void after(){
        System.out.println("after advice");
    }

    @AfterReturning("pctMethod()")
    public void afterReturning(){
        System.out.println("AfterReturning advice");
    }

    @AfterThrowing(value = "pctMethod()")
    public void afterThrowing(){
        System.out.println("AfterThrowing advice");
    }

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AopTestDemo aopTestDemo = applicationContext.getBean(AopTestDemo.class);
        aopTestDemo.method("测试AOP");
    }

}
