package com.haiduk.service;


import com.haiduk.domain.Order;
import com.haiduk.domain.Product;
import com.haiduk.domain.User;
import com.haiduk.repository.OrderRepository;
import com.haiduk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Autowired
    OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public void addProductToOrder(User user, String[] select) {
        List<Product> products;
        Double totalPrice;
        Order order;
        Product selectProduct = productRepository.getByName(select[0]);
        if (user.getOrders() == null) {
             order = new Order();
             products = new ArrayList<>();
            products.add(selectProduct);
            totalPrice = selectProduct.getPrice();
            order.setUser(user);
            order.setProductList(products);
            order.setTotalPrice(totalPrice);
            orderRepository.save(order);

        }else if(user.getOrders() != null){
            order = user.getOrders().get(0);
            products = order.getProductList();
            products.add(selectProduct);
            totalPrice = getTotalPrice(products);
            order.setTotalPrice(totalPrice);
            order.setProductList(products);
            orderRepository.updateOrder(order);


        }




    }

    public Double getTotalPrice(List<Product> totalPriceList) {
        Double totalPrice = 0.0;
        for (Product product : totalPriceList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }


}
