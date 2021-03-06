package com.haiduk.config;

import com.haiduk.repository.UserRepository;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.awt.image.RasterFormatException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.haiduk"})

public class AppConfig {
//    @Bean
//    public DataSource dataSource() {

//        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
//        return databaseBuilder
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("scripts/create_table.sql")
//                .addScript("scripts/insert_table.sql")
//                .setScriptEncoding("UTF-8")
//                .continueOnError(true)
//                .ignoreFailedDrops(true)
//                .build();
//    }

//public MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    @Bean
    MapperFacade mapperFacade() {
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }

}









