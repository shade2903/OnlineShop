package com.haiduk.converter;

import com.haiduk.domain.Order;
import com.haiduk.dto.OrderDto;
import com.haiduk.dto.ProductDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements MapperConverter<Order,OrderDto>    {

    private MapperFacade mapperFacade;
    @Autowired
    public OrderMapper(MapperFacade mapperFacade){
        this.mapperFacade = mapperFacade;
    }

    @Override
    public OrderDto toDto(Order entity) {
        return mapperFacade.map(entity, OrderDto.class);
    }

    @Override
    public Order fromDto(OrderDto dto) {
        return mapperFacade.map(dto, Order.class);
    }






}
