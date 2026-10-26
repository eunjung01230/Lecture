package com.wanted.container.section02.gateway;

public interface PaymentInterface {
    //결제 시 주문 번호와 수량 받도록 함
    boolean processPay(String orderId, int amount);
}