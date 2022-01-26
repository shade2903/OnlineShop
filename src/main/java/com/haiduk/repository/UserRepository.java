package com.haiduk.repository;

import com.haiduk.domain.Product;

import com.haiduk.sql.SqlHelper;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


@Repository
public class UserRepository {

    private static SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

//    private static Connection connection = SqlHelper.getConnection();
//
//    public static void addUser(String name){
//        Map<Integer,String> users = new HashMap<>();
//        ResultSet rs = null;
//        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO USERS(NAME) VALUES (?)")){
//            ps.setString(1,name);
//            ps.execute();
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }finally {
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    }
//    public static Integer getIDbyName(String name){
//        ResultSet rs = null;
//        try(PreparedStatement ps = connection.prepareStatement("SELECT id, NAME FROM USERS")) {
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                if(rs.getString("NAME").equals(name)){
//                    return rs.getInt("id");
//                }
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//
//        }finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return -1;
//    }

    public static Integer getIDbyName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT u.id from User u where u.name = :name");
        query.setParameter("name",name);
        return (Integer) query.list().get(0);

    }



}


