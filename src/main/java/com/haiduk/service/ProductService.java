package com.haiduk.service;

import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Transactional
@Service
public class ProductService {

    private ProductRepository productRepository;
  ProductService(ProductRepository productRepository){
      this.productRepository = productRepository;
  }
    public List<Product> getPriceList() {
        return productRepository.getAllHB();
    }

}
