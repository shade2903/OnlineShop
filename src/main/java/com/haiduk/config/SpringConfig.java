package com.haiduk.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfig {

    public static AnnotationConfigApplicationContext getApplicationContext() {
        return applicationContext;
    }

    private static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            AppConfig.class);
}
