package com.wanted.di.section02.gateway;

import org.springframework.stereotype.Component;

/* comment.
    @Component
    - Spring이 해당 클래스를 Bean으로 등록할 수 있게 지시.
    - 역할 : IoC 컨테이너가 관리해야 할 객체임을 명시한다.
    - 이름 : kakaoPayGateway -> 앞글자가 소문자로
 */

@Component
public class NaverPayGateway implements PaymentInterface {

    // 네이버페이 결제를 담당하는 메서드
    // 주문 번호 / 수량
    @Override
    public boolean processPay(String orderId, int amount) {
        System.out.println("네이버페이로 결제 시작! : 주문 ID = " + orderId + ", 수량 = " + amount);
        return true;
    }
}