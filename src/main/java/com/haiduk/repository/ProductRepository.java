package com.haiduk.repository;

import com.haiduk.domain.Product;
import com.haiduk.sql.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static Connection connection = SqlHelper.getConnection();
    public static List<Product> getAll(){
        List<Product> products = new ArrayList<>();
        ResultSet rs = null;
        try(PreparedStatement ps = connection.prepareStatement("SELECT id, title, price FROM PRICE_LIST")) {
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getString("title"), rs.getDouble("price")));
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
        return products;
    }
}
