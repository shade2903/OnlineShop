package com.haiduk.exception;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(String msg){
        super(msg);
    }
}
