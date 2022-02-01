package com.haiduk.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "ID", unique = true, nullable = false)
    private int id;

@Column(name="NAME", unique = true, nullable = false)
    private String name;

@Column(name="PASSWORD", nullable = false)
    private String password;
@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Order> orders;

    public User() {
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                '}';
    }
}

