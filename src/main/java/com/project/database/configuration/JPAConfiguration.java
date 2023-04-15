// package com.project.database.configuration;

// import java.util.Properties;

// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.orm.jpa.JpaTransactionManager;
// import org.springframework.orm.jpa.JpaVendorAdapter;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
// import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;

// @Configuration
// @EnableTransactionManagement
// //@EnableJpaRepositories(basePackages = "com.project.database.dao")
// public class JPAConfiguration {
//     @Autowired
//     DataSource dataSource;

//     @Bean
//     public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//         return new PersistenceExceptionTranslationPostProcessor();
//     }

//     @Bean
//     public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em 
//          = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan(new String[] { "com.project.database.dao" });
 
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
 
//        return em;
//     }

//     public Properties additionalProperties() {
//         Properties properties = new Properties();
//         properties.setProperty("hibernate.hbm2ddl.auto", "update");
//         properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
//         properties.setProperty("hibernate.show_sql", "true");
           
//         return properties;
//     }

//     @Bean
//     public PlatformTransactionManager transactionManager() {
//         JpaTransactionManager transactionManager = new JpaTransactionManager();
//         transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

//         return transactionManager;
//     }
// }
