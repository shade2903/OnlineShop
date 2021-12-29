package com.haiduk.config;
import com.haiduk.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = {"com.haiduk"})
    public class AppConfig {

        @Bean
        UserRepository userRepository() {
            return new UserRepository();
        }
        @Bean
        public InternalResourceViewResolver viewResolver(){
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
            resolver.setPrefix("/WEB-INF/jsp/");
            resolver.setSuffix(".jsp");
            return resolver;

        }







    }

