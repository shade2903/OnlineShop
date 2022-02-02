package com.haiduk.service;

import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class DataService {
    private ProductService productService;
    private List<String> name;
    private List<Product> selectList;
    private List<Product> priceList;
    @Autowired
    public DataService(ProductService productService){
        this.productService = productService;
    }




}
