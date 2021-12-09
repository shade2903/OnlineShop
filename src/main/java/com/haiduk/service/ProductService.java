package com.haiduk.service;

import com.haiduk.domain.Product;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    private static Double totalPrice= 0.0;
     public  Double getTotalPrice(List<Product> totalPriceList){
        for(Product product : totalPriceList){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
