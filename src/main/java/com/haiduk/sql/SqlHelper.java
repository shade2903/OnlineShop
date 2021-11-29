package com.haiduk.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class SqlHelper {
    private  static Connection connection = getConnection();


    public static Connection getConnection(){
        try {
            Class.forName("org.h2.Driver");
            return connection = DriverManager.getConnection("jdbc:h2:mem:my-base","sa","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("DAS");

    }

}
