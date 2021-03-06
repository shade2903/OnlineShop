package com.haiduk.dto;

import java.util.List;

public class OrderDto {
    private int id;
    private double totalPrice;
    private UserDto user;
    private List<ProductDto> products;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<ProductDto> getProductList() {
        return products;
    }

    public void setProductList(List<ProductDto> products) {
        this.products = products;
    }

    public OrderDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
