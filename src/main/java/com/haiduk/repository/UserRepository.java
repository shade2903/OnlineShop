package com.haiduk.repository;

import com.haiduk.domain.Product;
import com.haiduk.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static Connection connection = SqlHelper.getConnection();

    public static void addUser(String name){
        Map<Integer,String> users = new HashMap<>();
        ResultSet rs = null;
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO USERS(NAME) VALUES (?)")){
            ps.setString(1,name);
            ps.execute();
        } catch (SQLException e) {
        e.printStackTrace();
        }finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }






    }
    public static Integer getIDbyName(String name){
        ResultSet rs = null;
        try(PreparedStatement ps = connection.prepareStatement("SELECT id, NAME FROM USERS")) {
            rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getString("NAME").equals(name)){
                    return rs.getInt("id");
                }
                
            }
        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return 0;
    }


}

//ublic static Order save(Order order) {
//        Connection conn = SqlHelper.getConnection();
//        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO SHOP_ORDER (id, user_id, total_price) VALUES (?,?,?)")) {
//        ps.setInt(1, order.getId());
//        ps.setInt(2, order.getUserId());
//        ps.setDouble(3, order.getTotalPrice());
//        ps.execute();
//
//
//        for (Product product : order.getProducts()) {
//        ProductRepository.saveOrderGood(product, order.getId());
//        }
//
//
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }
//        return order;
//        }
//        }
