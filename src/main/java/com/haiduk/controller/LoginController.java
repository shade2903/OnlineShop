package com.haiduk.controller;

import com.haiduk.domain.PriceList;
import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

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
public String login(@RequestParam(value = "userName",required = false) String name, ModelMap model){
    System.out.println(name);

        model.addAttribute("products",productRepository.getAll());
    return "login";

}
}
