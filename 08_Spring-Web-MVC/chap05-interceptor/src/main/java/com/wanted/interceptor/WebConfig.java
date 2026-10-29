package com.wanted.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* comment.
    WebMvcConfigurer
    Spring MVC 패턴의 기본 설정은 유지하며
    추가적인 커스터마이징이 필요할 때 구현하는 인터페이스
    ex) 인터셉터 추가, CORS 설정, 정적 리소스 핸들링 등등 
 */
@Configuration  //환경설정 빈 어노테이션
public class WebConfig implements WebMvcConfigurer {
}

