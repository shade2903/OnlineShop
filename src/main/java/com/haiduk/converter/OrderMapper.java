package com.haiduk.converter;

import com.haiduk.domain.Order;
import com.haiduk.dto.OrderDto;
import com.haiduk.dto.ProductDto;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper  extends MapperConverterClass<Order,OrderDto>  {


    @Override
    Class<OrderDto> getDomainClass() {
        return OrderDto.class;
    }

    @Override
    Class<Order> getEntityClass() {
        return Order.class;
    }
}
