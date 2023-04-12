package com.project.database.task;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
    @Scheduled(cron = "40 * * * * *")
    public void myTask1() {
        System.out.println("This is my new task at second" + LocalDateTime.now().getSecond());
    }

    // initialDelay : Thời điểm delay khởi đầu
    // fixedDelay : Tần suất tính theo thời điểm task này end (Lệ thuộc time execute của task)
    // fixedRate : Tần suất tính theo thời điểm bắt đầu của 2 task (Không lệ thuộc time)
    //@Scheduled(initialDelay = 10000, 
        //fixedDelay = 1000)
        //fixedRate = 1000)
    public void myTask2(){
        try {
            Thread.sleep(3000);
            System.out.println("This task is run after 10 second and every 5 second after this task end or start");
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }
}
