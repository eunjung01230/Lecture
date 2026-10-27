package com.wanted.di.section02.service.constructor;

import com.wanted.di.section02.gateway.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 빈의 이름 지정 'constructor'
@Service("constructor")
public class PaymentServiceConstructor {

     /* comment
         @Autowired 어노테이션을 생성자에 붙인다.
         생성자 주입 방식은 생성자가 1개 뿐이라면 자동으로
         @Autowired를 작성하지 않더라도 의존성이 주입된다.
         ---
         장점
         1. final 키워드를 통해 의존성이 변경되는 것을 방지(불변성 보장)
         2. 필수 의존성 강제화
         - final 키워드를 작성하면 초기화를 반드시 해주어야 하는데 ( = 반드시 초기화 해야됨 )
         - 생성자로 주입하게 되면 객체의 생성 시점에 의존 관계를
         - 바로 정의할 수 있다.
         ---
         위 특징들로 인해서 생성자를 통한 의존성 주입 방식이
          Spring 공식 권장 방식이다.
      */

    private PaymentInterface paymentInterface;
    //private final PaymentInterface paymentInterface; // 오류 안남 생성하는 시점에 ---해서 final 상과없음
    //finall null로 초기화 생성되는 시점에 객체가 들어옴 / new를 통한 객체 생성은 동작과 동시에 초기화 + 객체 들어옴

    // @Autowired = 생성자가 1개면 알아서 의존성이 주입
    public PaymentServiceConstructor(PaymentInterface paymentInterface) {
        this.paymentInterface = paymentInterface;
    }

    public boolean processPay(String orderId, int amount) {

        // paymentInterface = new NaverPayGateway();  final이 있는 상태에서는 이거 주석 풀면 오류가 뜸

        System.out.println("결제 비즈니스 로직 시작! 주문 ID = " + orderId + ", 수량 = " + amount);

        boolean result = paymentInterface.processPay(orderId, amount);

        if(result) {
            System.out.println("결제 성공!");
        } else {
            System.out.println("결제 실패..");
        }
        return result;
    }
}