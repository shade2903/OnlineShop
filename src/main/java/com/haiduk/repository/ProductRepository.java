package com.haiduk.repository;

import com.haiduk.domain.Product;


import com.haiduk.sql.SqlHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
    private   SessionFactory sessionFactory;

    @Autowired
    ProductRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public  List<Product> getAllHB() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product");
        return query.list();
    }
    public Product getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product p where p.id = :id");
        query.setParameter("id", id);
        return (Product) query.list().get(0);
    }
    public  Product getByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product p where p.name = :name");
        query.setParameter("name", name);
        return (Product) query.list().get(0);
    }
}
