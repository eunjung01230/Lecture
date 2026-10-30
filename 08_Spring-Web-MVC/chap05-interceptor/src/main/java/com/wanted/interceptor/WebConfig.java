package com.wanted.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* comment.
    WebMvcConfigurer
    Spring MVC 패턴의 기본 설정은 유지하며
    추가적인 커스터마이징이 필요할 때 구현하는 인터페이스
    ex) 인터셉터 추가, CORS 설정, 정적 리소스 핸들링 등등
 */
@Configuration  //환경설정 빈 어노테이션
public class WebConfig implements WebMvcConfigurer {

    // 등록할 인터셉터 객체
    private final TimerInterceptor timerInterceptor;

    //생성자를 통한 Bean 간의 의존성 주입
    @Autowired
    public WebConfig(TimerInterceptor timerInterceptor) {
        this.timerInterceptor = timerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //만들어둔 인터셉터 등록
        registry.addInterceptor(timerInterceptor)
                // 인터셉터가 동작하게 만들 URL 경로 추가
                .addPathPatterns("/*")
                // 인터셉터 동작 시 정적인 요소 제외(= 이미지를 불러올때는 인터셉터를 하지 않는다는 뜻)
                //각 이미지 요청마다 intercep 히면 과부화 정적인 페이지?요소?에 관해 이것을 막는 것
                // /** : 모든 하위 경로까지 포함하는 패턴
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/video/**");
    }
}