package com.project.database.configuration;

// import java.io.File;

// import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
// import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    // Trong file này sẽ chứa các bean cần tạo cho việc autowired (Hoặc có thể dùng @Component để tạo bean tự động)
    
    // @Bean  (Nếu ở Class có @Component thì các dòng này là không cần thiết)
    // public UserValidator userValidator() {
    //     return new UserValidator();
    // }

    // Tomcat configuration (dành cho sping MVC, spring boot thì dùng application.properties)
    // @Bean
    // public ServletWebServerFactory servletContainer() {
    //     TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

    //     tomcat.setPort(8080);
    //     tomcat.setContextPath("/path");
    //     tomcat.setBaseDirectory(new File("./tomcat"));

    //     return tomcat;
    // }


}
