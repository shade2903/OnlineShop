package com.haiduk;

import com.haiduk.repository.OrderRepository;
import com.haiduk.repository.ProductRepository;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(OrderRepository.getIdByUSerId(737));
        System.out.println(ProductRepository.getIdByName("SODA"));
    }
}
