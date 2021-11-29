package com.haiduk;

import com.haiduk.sql.SqlHelper;

import java.sql.*;

public class MainApp {
    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test_db";
    private final static String USER = "sa";
    private final static String PASS = "";
    public static void main(String[] args) {
        SqlHelper.initDB();
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // STEP 1: Register JDBC driver
//            Class.forName(JDBC_DRIVER);
//
//            // STEP 2: Open a connection
//            System.out.println("Connecting to a selected database...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            System.out.println("Connected database successfully...");
//
//            // STEP 3: Execute a query
//            stmt = conn.createStatement();
//            String sql = "INSERT INTO PRICE_LIST (TITLE, PRICE) " + "VALUES ('VODKA',  18.0)";
//
//            stmt.executeUpdate(sql);
//
//            System.out.println("Inserted records into the table...");
//
//            // STEP 4: Clean-up environment
//            stmt.close();
//            conn.close();
//        } catch(SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch(Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if(stmt!=null) stmt.close();
//            } catch(SQLException se2) {
//            } // nothing we can do
//            try {
//                if(conn!=null) conn.close();
//            } catch(SQLException se) {
//                se.printStackTrace();
//            } // end finally try
//        } // end try
//        System.out.println("Goodbye!");
//            System.out.println("Connected database successfully...");
//            stmt = conn.createStatement();
//            String sql = "SELECT id, title, price FROM PRICE_LIST";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // STEP 4: Extract data from result set
//            while(rs.next()) {
//                // Retrieve by column name
//                int id  = rs.getInt("id");
//                String title = rs.getString("title");
//                Double price = rs.getDouble("price");
//
//
//                // Display values
//                System.out.print("ID: " + id);
//                System.out.print(", title: " + title);
//                System.out.print(", price: " + price);
//
//            }
//            // STEP 5: Clean-up environment
//            rs.close();
//        } catch(SQLException se) {
//            // Handle errors for JDBC
//            se.printStackTrace();
//        } catch(Exception e) {
//            // Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            // finally block used to close resources
//            try {
//                if(stmt!=null) stmt.close();
//            } catch(SQLException se2) {
//            } // nothing we can do
//            try {
//                if(conn!=null) conn.close();
//            } catch(SQLException se) {
//                se.printStackTrace();
//            } // end finally try
//        } // end try
//        System.out.println("Goodbye!");
    }
}

