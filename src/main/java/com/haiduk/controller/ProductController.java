package com.haiduk.controller;


import com.haiduk.domain.Order;
import com.haiduk.domain.Product;
import com.haiduk.domain.User;
import com.haiduk.dto.ProductDto;
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

@Controller
@Transactional

public class ProductController {

    private ProductService productService;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public ProductController( ProductService productService, OrderService orderService,
                             UserService userService) {
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;

    }

    @RequestMapping("/product")
    public String showMenu(Principal principal, @RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "select", required = false) String select, ModelMap model) {

        User user = userService.getUserByLogin(principal.getName());
        orderService.addProductToOrder(user, select);
        List<ProductDto> selectlist = null;
        if (select != null) {
            selectlist =  orderService.getOrderDto(user).getProductList();

        }
        model.addAttribute("userName", principal.getName());
        model.addAttribute("products", productService.getPriceList());
        model.addAttribute("clickList", selectlist);
        return "menu";
    }
}
