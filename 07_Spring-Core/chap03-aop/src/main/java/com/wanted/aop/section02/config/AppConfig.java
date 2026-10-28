package com.wanted.aop.section02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.wanted.aop.section02")
@EnableAspectJAutoProxy  // AOP로 요청 자체가 아니라 Spring Bean의 메서드 호출을 가로챌 수 있도록 설정
public class AppConfig {
}
