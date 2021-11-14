package com.haiduk.domain;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private static  final Map<String,Double> PRODUCTS =iniMap();

    public PriceList(){

    }

    public static Map<String, Double> getPRODUCTS() {
        return PRODUCTS;
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

}
