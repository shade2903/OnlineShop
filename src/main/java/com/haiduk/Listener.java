package com.haiduk;

import com.haiduk.config.SpringConfig;
import com.haiduk.sql.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("STart Connection");
        SqlHelper.initDB();
//        SpringConfig.getApplicationContext();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("end Connection");

    }
}
