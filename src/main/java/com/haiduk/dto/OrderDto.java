package com.haiduk.dto;

import java.util.List;

public class OrderDto {
    private int id;
    private double totalPrice;
    private UserDto userDTO;
    private List<ProductDto> productsDTO;

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

    public UserDto getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDto userDTO) {
        this.userDTO = userDTO;
    }

    public List<ProductDto> getProductsDTO() {
        return productsDTO;
    }

    public void setProductsDTO(List<ProductDto> productsDTO) {
        this.productsDTO = productsDTO;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", userDTO=" + userDTO +
                ", productsDTO=" + productsDTO +
                '}';
    }
}
