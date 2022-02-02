package com.haiduk.service;


import com.haiduk.converter.OrderMapper;
import com.haiduk.domain.Order;
import com.haiduk.domain.Product;
import com.haiduk.domain.User;
import com.haiduk.dto.OrderDto;
import com.haiduk.exception.UserNotFoundException;
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
    private OrderMapper orderMapper;

    @Autowired
    OrderService(ProductRepository productRepository, OrderRepository orderRepository,OrderMapper orderMapper) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public void addProductToOrder(User user, String select) {
        List<Product> products;
        Order order;
        if(user.getOrders().size() == 0){
            order = new Order();
            order.setUser(user);
            orderRepository.save(order);
        }else if(user.getOrders().size() !=0 && select != null){
            Product selectProduct = (productRepository.getById(Integer.parseInt(select)));
            order = getCurrentOrder(user);
            products = order.getProductList();
            products.add(selectProduct);
            order.setTotalPrice(getTotalPrice(products));
            order.setProductList(products);
            orderRepository.updateOrder(order);
         }else if(select == null && user.getOrders().size() != 0){
            order = new Order();
            order.setUser(user);
            orderRepository.save(order);
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
        if(user != null){

            return user.getOrders().get(user.getOrders().size()-1);
        }

        throw new UserNotFoundException("User not found in database");
    }

    public OrderDto getOrderDto(User user){
        return orderMapper.toDto(getCurrentOrder(user));
    }

    private Order getCurrentOrder(User user){
        return user.getOrders().get(user.getOrders().size() - 1);
    }


}
