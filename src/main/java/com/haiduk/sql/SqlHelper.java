package com.haiduk.sql;

import java.sql.*;

public class SqlHelper {
    private final static String JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test_dbm;DB_CLOSE_DELAY=-1;";
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
        try (PreparedStatement ps = connection.prepareStatement("" +
                "DROP TABLE IF EXISTS ORDER_PRICE_LIST;\n" +
                        "DROP TABLE IF EXISTS ORDERS;\n" +
                        "DROP TABLE IF EXISTS PRICE_LIST;\n" +
                        "DROP TABLE IF EXISTS USERS;" +

                "CREATE TABLE USERS(\n" +
                "ID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "NAME VARCHAR(255) NOT NULL,\n" +
                "PASSWORD VARCHAR(255));\n" +

                "CREATE TABLE PRICE_LIST(\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "title VARCHAR(36) NOT NULL,\n" +
                "price double NOT NULL);\n" +

                "CREATE TABLE ORDERS(\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "user_id INT,\n" +
                "total_price DOUBLE NOT NULL,\n" +
                "CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES USERS (ID));\n" +

                "CREATE TABLE ORDER_PRICE_LIST(\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "order_id INT,\n" +
                "price_id INT,\n" +
                "CONSTRAINT order_id FOREIGN KEY (order_id) REFERENCES ORDERS (ID),\n" +
                "CONSTRAINT good_id FOREIGN KEY (price_id) REFERENCES PRICE_LIST (ID));\n" +

                "INSERT INTO PRICE_LIST (TITLE, PRICE)\n" +
                "VALUES ('WHISKEY', 35.0);\n" +
                "INSERT INTO PRICE_LIST (TITLE, PRICE)\n" +
                "VALUES ('COLA', 5.0);\n" +
                "INSERT INTO PRICE_LIST (TITLE, PRICE)\n" +
                "VALUES ('SODA', 6.0);\n" +
                "INSERT INTO PRICE_LIST (TITLE, PRICE)\n" +
                "VALUES ('WATER', 1.0);\n" +
                "INSERT INTO PRICE_LIST (TITLE, PRICE)\n" +
                "VALUES ('GIN', 25.0);\n" +
                "INSERT INTO PRICE_LIST (TITLE, PRICE)\n" +
                "VALUES ('BEER', 10.0);")) {

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}
