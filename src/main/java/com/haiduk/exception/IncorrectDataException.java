package com.haiduk.exception;

public class IncorrectDataException extends RuntimeException {
    public IncorrectDataException(String massage){
        super(massage);
    }
}
