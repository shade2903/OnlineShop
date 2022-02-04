package com.haiduk.restcontroller;


import com.haiduk.dto.OrderDto;
import com.haiduk.dto.UserDto;
import com.haiduk.service.OrderService;
import com.haiduk.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;
    private UserService userService;


    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<OrderDto>> getAllUser() {
        List<OrderDto> orders = orderService.getOrders();
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping(value ="/users/{userId}/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getOrderByCurrentUser(@PathVariable int userId){
        return new  ResponseEntity(orderService.getOrderDto(userService.getUser(userId)),HttpStatus.OK);

    }
}
