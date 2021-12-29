package com.haiduk.controller;

import com.haiduk.domain.Product;
import com.haiduk.repository.OrderRepository;
import com.haiduk.repository.ProductRepository;
import com.haiduk.repository.UserRepository;
import com.haiduk.service.DataService;
import com.haiduk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public final class  BasketController {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private ProductService productService;
    private DataService dataService;

    @Autowired
    public BasketController(OrderRepository orderRepository,UserRepository userRepository, DataService dataService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.dataService = dataService;
        this.productService = productService;
    }
    @RequestMapping("/basket")
    public String showBasket(@RequestParam(value = "selectList", required = false) String[] selectList, ModelMap model){


        int userId = userRepository.getIDbyName(userRepository.getUserName());
        List<Product> basket = dataService.getSelectBasket(selectList);
        Double totalPrice = productService.getTotalPrice(basket);

        orderRepository.addOrder(userId, totalPrice);
        for (Product str : basket) {
            orderRepository.saveOrderPrice(orderRepository.getIdByUSerId(userId), str);
        }

        model.addAttribute("userName",userRepository.getUserName());
        model.addAttribute("selectList",basket);
        model.addAttribute("totalPrice",totalPrice);
        return "shoppingList";
    }

}
