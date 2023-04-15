package com.project.database.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.project.database"})
@PropertySource(value = {"classpath:application.properties"})
@EnableTransactionManagement
public class HibernateConfiguration {
    @Autowired
    DataSource dataSource;
    
    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("com.project.database.entity");

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.put("hibernate.hbm2ddl.auto","update");
        hibernateProperties.put("hibernate.show_sql","true");

        bean.setHibernateProperties(hibernateProperties);
        return bean;
    }

    @Bean 
    // Sử dụng cho Hibernate
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactoryBean().getObject());

        return hibernateTransactionManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(sessionFactoryBean().getObject());

        return transactionManager;
    }
}
