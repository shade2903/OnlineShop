package com.haiduk.controller;


import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;
import com.haiduk.repository.UserRepository;
import com.haiduk.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller

public final class ProductController {
    private final static List<Product> clickList = new ArrayList<>();
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private DataService dataService;

    @Autowired
    public ProductController(ProductRepository productRepository,UserRepository userRepository, DataService dataService) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.dataService = dataService;
    }

    @RequestMapping("/product")
    public String showMenu(Principal principal, @RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "select", required = false) String select, ModelMap model) {

        if(filter == null){
            clickList.clear();
        }
        if(select!=null){
            System.out.println(select);
            clickList.addAll(dataService.getSelect(select));
        }
        model.addAttribute("userName",principal.getName());
        model.addAttribute("products", productRepository.getAll());
        model.addAttribute("clickList",clickList);
        return "menu";
    }
}
