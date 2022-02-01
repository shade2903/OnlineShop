package com.haiduk.controller;

import com.haiduk.domain.Product;
import com.haiduk.domain.User;
import com.haiduk.repository.OrderRepository;
import com.haiduk.repository.ProductRepository;
import com.haiduk.repository.UserRepository;
import com.haiduk.service.DataService;
import com.haiduk.service.OrderService;
import com.haiduk.service.ProductService;
import com.haiduk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Controller
public  class  BasketController {

    private UserService userService;
    private OrderService orderService;



    @Autowired
    public BasketController( UserService userService, OrderService orderService) {

        this.userService = userService;
        this.orderService = orderService;


    }
    @RequestMapping("/basket")
    public String showBasket(Principal principal,  ModelMap model){
        System.out.println(orderService.getOrder(userService.getUserByLogin(principal.getName())));
        model.addAttribute("order",orderService.getOrder(userService.getUserByLogin(principal.getName())));

        System.out.println(orderService.getOrderDto(orderService.getOrder(userService.getUserByLogin(principal.getName()))));
        return "shoppingList";
    }

}
