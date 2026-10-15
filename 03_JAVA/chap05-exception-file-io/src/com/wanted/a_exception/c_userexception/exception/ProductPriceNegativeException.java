package com.wanted.a_exception.c_userexception.exception;

public class ProductPriceNegativeException extends NegativeException {
    //Negative는 Exception을 상속받으니 throws 필수 / Exception->RuntimeException으로 바뀌면 Run은 throws 안 필요
    public ProductPriceNegativeException(String message) {
        super(message);
    }
}
