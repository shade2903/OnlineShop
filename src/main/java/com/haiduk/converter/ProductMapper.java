package com.haiduk.converter;

import com.haiduk.domain.Order;
import com.haiduk.domain.Product;
import com.haiduk.dto.OrderDto;
import com.haiduk.dto.ProductDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements MapperConverter<Product, ProductDto> {

    private MapperFacade mapperFacade;

    @Autowired
    public ProductMapper(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }


    @Override
    public ProductDto toDto(Product entity) {

        return mapperFacade.map(entity, ProductDto.class);
    }

    @Override
    public Product fromDto(ProductDto dto) {
        return mapperFacade.map(dto, Product.class);
    }


}
