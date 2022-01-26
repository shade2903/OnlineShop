package com.haiduk.converter;

import com.haiduk.domain.Order;
import com.haiduk.dto.OrderDto;
import com.haiduk.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class OrderMapper {
    private UserMapper userMapper;
    private ProductMapper productMapper;
//    @Autowired
    public OrderMapper(UserMapper userMapper,ProductMapper productMapper){
        this.userMapper = userMapper;
        this.productMapper = productMapper;
    }
    OrderDto toDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setTotalPrice(order.getTotalPrice());

        orderDto.setUserDTO(userMapper.toDto(order.getUser()));
        return orderDto;

    }
    Order toEntity(OrderDto orderDto){
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setTotalPrice(orderDto.getTotalPrice());
       return order;
    }

}
