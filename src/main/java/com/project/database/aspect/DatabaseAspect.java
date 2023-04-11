package com.project.database.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatabaseAspect {
    @Pointcut("execution(* org.springframework.jdbc.core.JdbcTemplate.*(..))")
    public void jdbcCut() {}

    @After("jdbcCut()")
    public void jdbcLog(JoinPoint joinPoint) {
        System.out.println("JDBC query execute");
    }

    @Pointcut("execution(* org.hibernate.SessionFactory.openSession*(..)) "
                + "|| execution(* org.hibernate.query.Query.*(..))")
    public void hibernateCut() {}

    @After("hibernateCut()")
    public void hibernateLog(JoinPoint joinPoint) {
        System.out.println("Hibernate query execute " + joinPoint.getTarget().getClass().getName() + " "+ joinPoint.getSignature().getName());
    }
}
