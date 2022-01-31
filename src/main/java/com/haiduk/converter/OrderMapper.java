package com.haiduk.converter;

import com.haiduk.domain.Order;
import com.haiduk.dto.OrderDto;
import com.haiduk.dto.ProductDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper  {

    private MapperFacade mapperFacade;
    @Autowired
    public OrderMapper(MapperFacade mapperFacade){
        this.mapperFacade = mapperFacade;
    }



    public OrderDto toDto(Order entity) {

        return mapperFacade.map(entity, OrderDto.class);
    }

    public Order fromDto(OrderDto dto) {
        return mapperFacade.map(dto, Order.class);
    }






}
