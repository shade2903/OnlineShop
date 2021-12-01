package com.haiduk.domain;

import com.haiduk.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceList {

    private static final List<Product> PRODUCT= iniList();
    public PriceList(){ }
    public static List<Product> getListProduct(){
        return PRODUCT;
    }
    private static List<Product> iniList(){
        return ProductRepository.getAll();
    }

}
