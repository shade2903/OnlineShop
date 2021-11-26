package com.haiduk.service;

import com.haiduk.domain.Product;

import java.util.ArrayList;

public class ProductService {
    private static Double totalPrice= 0.0;


     public  Double getTotalPrice(ArrayList<Product> totalPriceList){
        for(Product product : totalPriceList){
            totalPrice += product.getPrice();

        }
        return totalPrice;
    }
}
