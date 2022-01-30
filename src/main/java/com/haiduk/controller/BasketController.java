package com.haiduk.controller;

import com.haiduk.domain.Product;
import com.haiduk.domain.User;
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

    private UserService userService;


    @Autowired
    public BasketController( UserService userService) {

        this.userService = userService;

    }
    @RequestMapping("/basket")
    public String showBasket(Principal principal, @RequestParam(value = "selectList", required = false) String[] selectList, ModelMap model){

        User user = userService.getUserByLogin(principal.getName());
        List<Product> selectProduct = user.getOrders().get(user.getOrders().size() - 1).getProductList();
        Double totalPrice = user.getOrders().get(user.getOrders().size() - 1).getTotalPrice();
        model.addAttribute("userName",principal.getName());
        System.out.println(user.getOrders().get(user.getOrders().size() - 1).getProductList());
        model.addAttribute("selectList",selectProduct);
        model.addAttribute("totalPrice",totalPrice);
        return "shoppingList";
    }

}
