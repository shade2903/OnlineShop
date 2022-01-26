package com.haiduk.controller;

import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;
import com.haiduk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;

@Transactional
@Controller
public  class LoginController {


    private ProductRepository productRepository;


    @Autowired
     public LoginController(ProductRepository productRepository){
         this.productRepository = productRepository;

     }

    @GetMapping("/")
    public String showToLoginPage(){
       

        return "login";
    }


@RequestMapping("/login")
public String login(Principal principal, ModelMap model){

        if(principal != null) {
            model.addAttribute("products", productRepository.getAllHB());
            model.addAttribute("userName", principal.getName());
            return "product";
        }

    return "login";

}
@PostMapping("/logout")
    public String logout(){
        return "redirect:/login?logout";
}
}
