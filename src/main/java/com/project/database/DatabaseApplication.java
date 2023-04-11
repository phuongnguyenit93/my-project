package com.project.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableScheduling
@EnableAspectJAutoProxy
// Do Hibernate ORM phiên bản mới nó có HibernateJPAAuto class, sẽ gây ra lỗi sau
// java.lang.ClassCastException: org.springframework.orm.jpa.EntityManagerHolder cannot be cast to org.springframework.orm.hibernate5.SessionHolder]
// Do Hibernate transaction xài class EntityManager 
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

}
