package com.haiduk.controller;


import com.haiduk.domain.Product;
import com.haiduk.repository.ProductRepository;
import com.haiduk.repository.UserRepository;
import com.haiduk.service.DataService;
import com.haiduk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional

public  class ProductController {
    private final static List<Product> clickList = new ArrayList<>();
    private DataService dataService;
    private ProductService productService;

    @Autowired
    public ProductController( DataService dataService, ProductService productService) {

        this.dataService = dataService;
        this.productService = productService;
    }

    @RequestMapping("/product")
    public String showMenu(Principal principal, @RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "select", required = false) String select, ModelMap model) {

        if(filter == null){
            clickList.clear();
        }
        if(select!=null){
            clickList.addAll(dataService.getSelect(select));
        }
        model.addAttribute("userName",principal.getName());
        model.addAttribute("products", productService.getPriceList());
        model.addAttribute("clickList",clickList);
        return "menu";
    }
}
