package com.wanted.container.section01;

import com.wanted.container.section01.service.PaymentService;

public class Appplication {
    public static void main(String[] args) {

        System.out.println("======Spring 없이 객체를 직접 생성 했을 때======");

        /* comment.
            우리 프로젝트는 결제 시스템이 있으며,
            KakaoPay, NaverPay 가 있다.
            Application에서는 PaymentService를
            호출하면 상황에 맞는 Pay를 호출해서
            결제가 되는 시나리오를 구성한다.
         */

        //  객체 생성
        PaymentService paymentService = new PaymentService();
        //주문번호, 수량 전달
        boolean result = paymentService.processPay("order-001", 3);

        System.out.println("결제 결과 : " + result);
    }
}
