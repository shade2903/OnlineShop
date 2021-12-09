package com.haiduk.config;

import com.haiduk.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.haiduk"})
public class AppConfig {
//    @Bean
//    public static ApplicationContext applicationContext(){
//       return new AnnotationConfigApplicationContext(AppConfig.class);
//    }
//    @Bean
//    ProductService productService(){
//        return new ProductService();
//    }

}
