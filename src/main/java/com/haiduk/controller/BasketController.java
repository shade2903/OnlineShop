package com.haiduk.controller;

import com.haiduk.domain.Product;
import com.haiduk.repository.OrderRepository;
import com.haiduk.repository.ProductRepository;
import com.haiduk.repository.UserRepository;
import com.haiduk.service.DataService;
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
    private OrderRepository orderRepository;
    private ProductService productService;
    private DataService dataService;
    private UserService userService;


    @Autowired
    public BasketController(OrderRepository orderRepository, DataService dataService,
                            ProductService productService, UserService userService) {
        this.orderRepository = orderRepository;
        this.dataService = dataService;
        this.productService = productService;
        this.userService = userService;

    }
    @RequestMapping("/basket")
    public String showBasket(Principal principal, @RequestParam(value = "selectList", required = false) String[] selectList, ModelMap model){


       int userId = userService.getUserByLogin(principal.getName()).getId();
        List<Product> basket = dataService.getSelectBasket(selectList);
        Double totalPrice = productService.getTotalPrice(basket);

        orderRepository.addOrder(userId, totalPrice);
        for (Product str : basket) {
            orderRepository.saveOrderPrice(orderRepository.getIdByUSerId(userId), str);
        }
        model.addAttribute("userName",principal.getName());
        model.addAttribute("selectList",basket);
        model.addAttribute("totalPrice",totalPrice);

                return "shoppingList";
    }

}
