package com.project.database.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration{

    // Vì WebSecurityConfigurerAdapter đã deprecated nên ta sẽ làm theo cách khác
    // https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
    @Autowired
    DataSource dataSource;

    @Bean
    @Autowired
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
          .password(bCryptPasswordEncoder.encode("user"))
          .roles("USER")
          .build());
        manager.createUser(User.withUsername("admin")
          .password(bCryptPasswordEncoder.encode("admin"))
          .roles("USER","MOD","ADMIN")
          .build());
        manager.createUser(User.withUsername("moderator")
          .password(bCryptPasswordEncoder.encode("moderator"))
          .roles("MOD","USER")
          .build());

        JdbcUserDetailsManager users = new JdbcUserDetailsManager();
        users.setDataSource(dataSource);

        // Khi muốn dùng từ database , phải tạo 2 bảng là users và authorities . Chi tiết xem tại doc của class tại spring
        // thay manager = users khi muốn lấy list bằng database
        return manager;
    }

    @Bean
    @Autowired
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService) 
        throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder)
            .and()
            .build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionListener httpSessionListener() {
      return new HttpSessionListener() {
        @Override
        public void sessionCreated(HttpSessionEvent ev) {
          System.out.println("Session created");
        }

        @Override
        public void sessionDestroyed(HttpSessionEvent ev) {
          System.out.println("Session destroyed");
        }
      };
    }

    // permitAll() : Cho phép tất cả phía trước
    // authenticated() : Phải xác thực
    // antMatchers("/path") : Setup các đường dẫn
    // cors() , csrf() : Các thuộc tính bảo vệ website ("có thể dùng kèm . disable()")
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> 
              authorizeRequests
                .antMatchers("/user-jdbc").authenticated()
                .antMatchers("/user-hibernate").hasRole("USER")
                .antMatchers("/user-jpa").hasRole("ADMIN")
                //.antMatchers("/actuator/**").hasRole("ADMIN")
                .anyRequest().permitAll()
            )
            .cors(
              cors -> cors.disable()
            )
            .csrf(
              csrf -> csrf.disable()
            )
            .sessionManagement(session -> session
              .maximumSessions(1)
              .maxSessionsPreventsLogin(true)
            )
            .formLogin(
              formlogin -> formlogin.permitAll()
            );
            
        return http.build();
    }
}
