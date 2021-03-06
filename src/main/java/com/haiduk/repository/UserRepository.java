package com.haiduk.repository;
import com.haiduk.domain.Order;
import com.haiduk.domain.Product;
import com.haiduk.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;



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
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public  Integer getIDbyName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT u.id from User u where u.name = :name");
        query.setParameter("name",name);
        return (Integer) query.list().get(0);
    }

    public User getByName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.name = :name");
        query.setParameter("name",name);
        List users =  query.list();
        return (User) users.get(0);
    }
    public User getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.id = :id");
        query.setParameter("id", id);
        return (User) query.list().get(0);
    }

    public List<User> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.list();
    }


}


