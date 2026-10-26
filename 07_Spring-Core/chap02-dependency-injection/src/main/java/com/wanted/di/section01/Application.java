package com.wanted.di.section01;

import com.wanted.di.section01.config.AppConfig;
import com.wanted.di.section01.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* comment
            AppConfig 파일 하위에 Bean들을 정의해서
            IoC 컨테이너에 등록 했었다.
            ---
            문제 제기! : 만약 Bean이 100개 라면?
         */

        // IoC Container 생성
        // IoC Container == Application Context == Bean Factory
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        //getBean으로 등록되어 있는 객체 꺼내오기
        PaymentService pay = context.getBean("paymentService", PaymentService.class);
        pay.processPay("order-003",3);
    }

}