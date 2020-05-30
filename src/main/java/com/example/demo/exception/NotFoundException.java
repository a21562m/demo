package com.example.demo.exception;

public class NotFoundException  extends GlobalException {

    public NotFoundException(String message, int code)
    {
        super(message, code);
    }
}
