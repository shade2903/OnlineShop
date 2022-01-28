package com.haiduk.repository;

import com.haiduk.domain.Product;

import com.haiduk.domain.User;
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

    private  SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public  User save(User user){
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    public  Integer getIDbyName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT u.id from User u where u.name = :name");
        query.setParameter("name",name);
        return (Integer) query.list().get(0);
    }

    public User getByName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.name = :name");
        query.setParameter("name",name);
        return (User) query.list().get(0);
    }



}


