package com.wanted.aop.section02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.wanted.aop.section02")
@EnableAspectJAutoProxy  // AOP로 요청을 낚아챌 권리는 줌
public class AppConfig {
}
