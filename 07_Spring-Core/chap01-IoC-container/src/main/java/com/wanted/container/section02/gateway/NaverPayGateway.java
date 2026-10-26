package com.wanted.container.section02.gateway;

public class NaverPayGateway implements PaymentInterface {

    //인터페이스에서 구현하도록 한 메서드
    @Override
    public boolean processPay(String orderId, int amount) {
        System.out.println("네이버페이로 결제 시작! : 주문 ID = " + orderId + ", 수량 = " + amount);
        return true;
    }
}
