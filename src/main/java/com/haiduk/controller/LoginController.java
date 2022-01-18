package com.haiduk.controller;

import com.haiduk.repository.ProductRepository;
import com.haiduk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public final class LoginController {


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
            System.out.println(UserRepository.getUserName());
            model.addAttribute("products", productRepository.getAll());
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
