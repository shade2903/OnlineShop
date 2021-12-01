package com.haiduk.repository;

import com.haiduk.sql.SqlHelper;

import java.sql.Connection;

public class OrderRepository {
    Connection connection = SqlHelper.getConnection();

    public static void addOrder(int user_id, Double totalPrice){


    }

}
