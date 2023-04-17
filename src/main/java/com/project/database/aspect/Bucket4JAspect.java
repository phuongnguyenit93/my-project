package com.project.database.aspect;

import java.util.ArrayList;
import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.giffing.bucket4j.spring.boot.starter.context.metrics.MetricTagResult;

@Aspect
@Component
public class Bucket4JAspect {

    @Pointcut("execution(* com.giffing.bucket4j.spring.boot.starter.context..handle*(..))")
    public void antiDdosCut() {}

    @After("antiDdosCut()") 
    public void antiDdosLog(JoinPoint joinPoint) {       

        for (Object obj : joinPoint.getArgs()) {
            if (obj instanceof Enum) {
                if (obj.toString().equals("REJECTED_COUNTER")) {
                    System.out.println("Bucket4j : Some one has reached rate limit. Detail Info :");
                    continue;
                } else {
                    return;
                }
            }
            
            if (obj instanceof ArrayList) {
                ArrayList<Object> list = new ArrayList<>((Collection<?>) obj);
                for (Object obj1 : list) {
                    MetricTagResult metric = (MetricTagResult) obj1;
                    switch (metric.getKey()) {
                        case "IP" : {
                            System.out.println("IP Address : " + metric.getValue());
                            break;
                        }
                        case "URL" : {
                            System.out.println("URL Request : " + metric.getValue());
                            break;
                        }
                    }
                }
            }
        }
    }    
}
