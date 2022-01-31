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

    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }



}
