package com.wanted.container.section02;

import com.wanted.container.section01.service.PaymentService;
import com.wanted.container.section02.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Appplication {
    public static void main(String[] args) {

        /* comment.
            section01에서 개발자가 직접 new
            직접 new 키워드로 객체를 생서하게 되면
            객체 간의 결합도가 높아지며, 코드의 유연성이
            떨어지게 된다. == 유지보수가 어려워진다.
         */

        // IoC Container 생성
        // IoC Container == Application Context == Bean Factory
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // getBean() : 컨테이너 내부에 있는 객체를 꺼내오는 메서드
        //context.getBean("paymentService");
        PaymentService paymentService = context.getBean("paymentService",PaymentService.class);


        //주문번호, 수량 전달
        boolean result = paymentService.processPay("order-001", 3);

        System.out.println("결제 결과 : " + result);

    }

}

