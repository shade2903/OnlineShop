package com.haiduk.repository;

import com.haiduk.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
   private static Connection connection = SqlHelper.getConnection();

    public static void addOrder(int user_id, Double totalPrice) {

        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO ORDERS (user_id,total_price) VALUES (?,?)")) {
            ps.setInt(1, user_id);
            ps.setDouble(2, totalPrice);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
    }

}
