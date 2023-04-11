package com.project.database.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfiguration {
    // Kết nối project với database thông qua JDBC bằng @Bean

    // Cách sử dụng biến application.properties
    @Value("${driverDataSource}")
    String className;

    // Khai báo biến môi trường để sử dụng application.properties
    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(className);
        dataSource.setUrl(env.getProperty("urlDataSource"));
        dataSource.setUsername(env.getProperty("usernameDataSource")); 
        dataSource.setPassword(env.getProperty("passwordDataSource")); 

        return dataSource;
    }
}