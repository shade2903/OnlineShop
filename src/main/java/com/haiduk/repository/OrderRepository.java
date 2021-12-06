package com.haiduk.repository;

import com.haiduk.domain.Product;
import com.haiduk.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public static int getIdByUSerId(int userId){

        ResultSet rs = null;
        int orderId = -1;
        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM ORDERS WHERE USER_ID = ?")){
            ps.setInt(1,userId);
            rs = ps.executeQuery();
            if(!rs.next()){

            }
            orderId = rs.getInt("ID");


        }catch (SQLException e) {
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
        return orderId;

    }

    public static void saveOrderPrice(int idOrder, Product product){
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO ORDER_PRICE_LIST (order_id, price_id) VALUES (?,?)")) {
            ps.setInt(1, idOrder);
            ps.setInt(2, product.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}