package com.haiduk.converter;

import com.haiduk.domain.Product;
import com.haiduk.dto.ProductDto;
import org.springframework.stereotype.Component;

//@Component
public class ProductMapper  {



    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setName(product.getName());
        return productDto;
    }


    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());

        return product;
    }
}
