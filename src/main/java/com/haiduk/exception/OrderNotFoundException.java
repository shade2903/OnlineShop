package com.haiduk.exception;

public class OrderNotFoundException extends RuntimeException{
    OrderNotFoundException(String msg){
        super(msg);
    }
}
