package com.haiduk.service;


import com.haiduk.domain.Order;
import com.haiduk.domain.Product;
import com.haiduk.domain.User;
import com.haiduk.repository.OrderRepository;
import com.haiduk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class OrderService {

    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Autowired
    OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public void addProductToOrder(User user, String select) {
        List<Product> products;
        Double totalPrice;
        Order order;
        Product selectProduct = productRepository.getByName(select);
        if (user.getOrders().size() == 0) {
             order = new Order();
             products = new ArrayList<>();
            products.add(selectProduct);
            totalPrice = selectProduct.getPrice();
            System.out.println("TEST1");

            order.setProductList(products);
            order.setTotalPrice(totalPrice);

            System.out.println("TEST2");
            List<Order> orders = new ArrayList<>();
            orders.add(order);
            System.out.println("TEST3");
            order.setUser(user);

            System.out.println(user.getOrders());
            System.out.println(order);
            orderRepository.updateOrder(order);
        }else if(user.getOrders().size() !=0){
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
    public Order getOrder(User user){
        return user.getOrders().get(0);
    }


}
