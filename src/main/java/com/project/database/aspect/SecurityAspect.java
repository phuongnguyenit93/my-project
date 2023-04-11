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
public class SecurityAspect {

    public static String classNameReturn(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().getSimpleName();
    }

    public static String methodNameReturn(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }

    @Pointcut("execution(* com.project.database.controller.SecurityController.*(..))"
            + "|| execution(* org.springframework.security.web.session..*(..))"
            )
    public void loggingCut() {}

    @Pointcut("execution(* com.project.database.controller.SecurityController.setAuthentication(..)) && args(arg1,arg2)")
    public void signUpCut(Object arg1 , Object arg2) {}

    @Pointcut("execution(* javax.servlet.http.HttpSessionListener.*(..))")
    public void sessionCut() {}

    @Before("loggingCut()")
    public void logSecurityStart(JoinPoint joinPoint) {
        System.out.println("Method " + methodNameReturn(joinPoint) + " at class " + classNameReturn(joinPoint) + " started at " + LocalDateTime.now());
    }
    
    @After("signUpCut(arg1, arg2)")
    public void logTimeSignup(JoinPoint joinPoint,Object arg1 , Object arg2) {
        System.out.println("An account has login at controller " + classNameReturn(joinPoint) + " with method " + methodNameReturn(joinPoint) + " with username " + arg1.toString());
    }

    @After("sessionCut()")
    public void sessionTrigger(JoinPoint joinPoint) {
        System.out.println("Session trigger with " + methodNameReturn(joinPoint) + " in cotroller " + classNameReturn(joinPoint));
    }
}
