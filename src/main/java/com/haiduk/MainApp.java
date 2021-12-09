package com.haiduk;

import com.haiduk.config.AppConfig;
import com.haiduk.config.SpringConfig;
import com.haiduk.domain.Product;
import com.haiduk.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("oooo",23.0));
        products.add(new Product("oo20",7.0));

        ApplicationContext applicationContext = SpringConfig.getApplicationContext();

        ProductService productService = applicationContext.getBean(ProductService.class);


        System.out.println(productService.getTotalPrice(products));

    }
}
