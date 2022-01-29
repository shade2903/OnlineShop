package com.haiduk.repository;

import com.haiduk.domain.Order;
import com.haiduk.domain.Product;

import com.haiduk.sql.SqlHelper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OrderRepository {


   private SessionFactory sessionFactory;
   OrderRepository (SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
   }


   private  Connection connection = SqlHelper.getConnection();


    public  void addOrder(int user_id, Double totalPrice) {

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
    public  int getIdByUSerId(int userId){
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

    public  void saveOrderPrice(int idOrder, Product product){
        try (PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO ORDERS_GOODS (order_id, good_id) VALUES (?,?)")) {
            ps.setInt(1, idOrder);
            ps.setInt(2, product.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order save(Order order) {
        sessionFactory.getCurrentSession().save(order);
        return order;
    }
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }



}
