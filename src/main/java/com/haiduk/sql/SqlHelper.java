package com.haiduk.sql;

import java.sql.*;

public class SqlHelper {
    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String USER = "sa";
    private final static String PASS = "";

    private  static Connection connection = getConnection();


    public static Connection getConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to a database...");
            System.out.println("Connected database successfully...");
            return connection = DriverManager.getConnection(DB_URL,USER,PASS);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("DAS");

    }
    public static void initDB(){
        try (PreparedStatement ps = connection.prepareStatement("" +
                "INSERT INTO PRICE_LIST (TITLE, PRICE)\n" +
                "VALUES ('TEKILA', 100.0);\n")) {


            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
