package com.wanted.a_exception.c_userexception.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {

        super(message);
    }
}
