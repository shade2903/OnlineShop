package com.haiduk;

import com.haiduk.config.SpringContext;
import com.haiduk.domain.Product;
import com.haiduk.service.ProductService;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("oooo",23.0));
        products.add(new Product("oo20",7.0));

        ApplicationContext applicationContext = SpringContext.getApplicationContext();

        ProductService productService = applicationContext.getBean(ProductService.class);


        System.out.println(productService.getTotalPrice(products));

    }
}
