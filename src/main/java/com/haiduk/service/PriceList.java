package com.haiduk.service;

import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;


import java.util.List;


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
