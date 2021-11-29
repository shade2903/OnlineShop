package com.haiduk.domain;

import com.haiduk.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceList {

    private static final List<Product> PRODUCT= iniList();

    public PriceList(){

    }


    public static List<Product> getListProduct(){
        return PRODUCT;
    }


    private static List<Product> iniList(){
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Product1",30.0));
//        products.add(new Product("Product2",10.0));
//        products.add(new Product("Product3",45.0));
//        products.add(new Product("Product4",50.0));
//        products.add(new Product("Product5",310.0));
//        return  products;
        return ProductRepository.getAll();
    }

}
