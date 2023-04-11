package com.project.database.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    // Trong file này sẽ chứa các bean cần tạo cho việc autowired (Hoặc có thể dùng @Component để tạo bean tự động)
    
    // @Bean  (Nếu ở Class có @Component thì các dòng này là không cần thiết)
    // public UserValidator userValidator() {
    //     return new UserValidator();
    // }
}
