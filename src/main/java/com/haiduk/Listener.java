package com.haiduk;

import com.haiduk.sql.SqlHelper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("STart Connection");
        SqlHelper.initDB();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("end Connection");

    }
}
