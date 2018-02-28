package com.yjy.security.web.TimeAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 1、能拿到请求参数；
 * 2、拿不到request和response；
 */
@Aspect
@Component
public class TimeAspect {

    @Pointcut("execution(* com.yjy.security.web.controller.UserController.*(..))")
    public void handleControllerMethod() {

    }

    @Around("handleControllerMethod()")
    public Object time(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("time aspect start");
        long start = System.currentTimeMillis();

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }
        Object object = proceedingJoinPoint.proceed();

        System.out.println("time aspect 耗时:" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("time aspect end");

        return object;
    }
}
