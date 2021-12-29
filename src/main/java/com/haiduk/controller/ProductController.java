package com.haiduk.controller;


import com.haiduk.repository.ProductRepository;
import com.haiduk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ProductController {

    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public ProductController(ProductRepository productRepository,UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping("/product")
    public String login(@RequestParam(value = "userName", required = false) String name, ModelMap model) {
        System.out.println(name);
        if(name!= null){
            userRepository.addUser(name);

        }
        System.out.println(userRepository.getUserName());
        model.addAttribute("userName",userRepository.getUserName());

        model.addAttribute("products", productRepository.getAll());
        return "menu";
    }
}
