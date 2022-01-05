package com.haiduk;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Start Connection");
//        SqlHelper.initDB();


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("end Connection");

    }
}
