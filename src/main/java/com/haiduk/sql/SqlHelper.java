package com.haiduk.sql;

import java.sql.*;

public class SqlHelper {
    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test_db";
    private final static String USER = "sa";
    private final static String PASS = "";

    private  static Connection connection = getConnection();
    static Statement stmt = null;


    public static Connection getConnection(){
        try {
            Class.forName(JDBC_DRIVER);

            return connection = DriverManager.getConnection(DB_URL,USER,PASS);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("DAS");

    }
    public static void initDB(){
        try{
        System.out.println("Connected database successfully...");
        stmt = connection.createStatement();
        String sql = "SELECT id, title, price FROM PRICE_LIST";
        ResultSet rs = stmt.executeQuery(sql);

        // STEP 4: Extract data from result set
        while(rs.next()) {
            // Retrieve by column name
            int id  = rs.getInt("id");
            String title = rs.getString("title");
            Double price = rs.getDouble("price");


            // Display values
            System.out.print("ID: " + id);
            System.out.print(", title: " + title);
            System.out.print(", price: " + price);

        }
        // STEP 5: Clean-up environment
        rs.close();
    } catch(SQLException se) {
        // Handle errors for JDBC
        se.printStackTrace();
    } catch(Exception e) {
        // Handle errors for Class.forName
        e.printStackTrace();
    } finally {
        // finally block used to close resources
        try {
            if(stmt!=null) stmt.close();
        } catch(SQLException se2) {
        } // nothing we can do
        try {
            if(connection!=null) connection.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } // end finally try
    } // end try
        System.out.println("Goodbye!");
    }




}
