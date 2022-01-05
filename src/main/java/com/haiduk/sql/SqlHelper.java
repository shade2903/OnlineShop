package com.haiduk.sql;

import org.springframework.context.annotation.Bean;

import java.sql.*;

public class SqlHelper {
    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;";
    private final static String USER = "sa";
    private final static String PASS = "";

    private  static Connection connection = getConnection();


@Bean
    public static Connection getConnection(){
        try {
            Class.forName(JDBC_DRIVER);

            return connection = DriverManager.getConnection(DB_URL,USER,PASS);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException(" Error Connection Database");

    }





}
