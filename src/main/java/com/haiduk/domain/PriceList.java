package com.haiduk.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private static  final Map<String,Double> PRODUCTS =iniMap();
    private static final ArrayList<Product> PRODUCT_ARRAY_LIST = iniList();

    public PriceList(){

    }

    public static Map<String, Double> getPRODUCTS() {
        return PRODUCTS;
    }
    public static ArrayList<Product> getListProduct(){
        return PRODUCT_ARRAY_LIST;
    }

    private static Map<String,Double> iniMap(){
        Map<String, Double> products = new HashMap<>();
        products.put("Product1", 30.0);
        products.put("Product2", 10.0);
        products.put("Product3", 40.0);
        products.put("Product4", 60.0);
        products.put("Product5", 340.0);
        return products;
    }
    private static ArrayList<Product> iniList(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Product1",30.0));
        products.add(new Product("Product2",10.0));
        products.add(new Product("Product3",45.0));
        products.add(new Product("Product4",50.0));
        products.add(new Product("Product5",310.0));
        return  products;





    }

}
