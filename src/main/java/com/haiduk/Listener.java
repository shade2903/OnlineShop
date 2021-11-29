package com.haiduk;

import com.haiduk.sql.SqlHelper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SqlHelper.initDB();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
