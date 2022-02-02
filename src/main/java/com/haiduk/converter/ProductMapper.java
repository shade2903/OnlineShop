package com.haiduk.converter;

import com.haiduk.domain.Order;
import com.haiduk.domain.Product;
import com.haiduk.dto.OrderDto;
import com.haiduk.dto.ProductDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends MapperConverterClass<Product,ProductDto> {


    @Override
    Class<ProductDto> getDomainClass() {
        return ProductDto.class;
    }

    @Override
    Class<Product> getEntityClass() {
        return Product.class;
    }
}
