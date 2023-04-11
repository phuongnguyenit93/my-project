package com.project.database.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    // .. thì sẽ áp dụng cho mọi class và subpackage kèm theo 
    @Pointcut("execution(* com.project.database.task..*(..))")
    public void loggingCut() {}

    @Before("loggingCut()")
    public void myTask2(JoinPoint joinPoint) {
        System.out.println("This task has been start at " + LocalDateTime.now() + " with method " + joinPoint.getSignature().getName() + " in class " + joinPoint.getTarget().getClass().getName());
    }

    @After("loggingCut()")
    public void myTask3(JoinPoint joinPoint) {
        System.out.println("This task has been finished at " + LocalDateTime.now() + " with method " + joinPoint.getSignature().getName() + " in class "  + joinPoint.getTarget().getClass().getName());
    }
}
