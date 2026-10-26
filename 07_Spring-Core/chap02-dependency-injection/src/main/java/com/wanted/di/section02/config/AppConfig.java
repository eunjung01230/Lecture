package com.wanted.di.section02.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/* comment.
 *   IoC 컨테이너에게 등록할 객체를 모아둔
 *   설정 클래스
 *   Bean : Bean 은 Spring 에서 객체를 의미하는 단어.
 *  */
@Configuration
/* comment.
    @ComponentScan 은 지정된 패키지에서
    @Component 관련 어노테이션이 붙은
    클래스를 스캔하여 Bean으로 등록해준다. 직접 bean으로 객체를 생성하는 것 대신
    ---
    basePackages 지정을 하지 않으면
    스캔의 범위가 @ComponentScan 달려있는 클래스와
    동일한 레벨(같은 패키지)까지만 스캔이 가능하다.
    ---
    만약 scan 범위에서 제외하고자 하면
    excludeFilter를 활용할 수 있다.
 */
//@ComponentScan (basePackages = "com.wanted.di.section01",
//    excludeFilters = @ComponentScan.Filter(
//            // 1. 클래스명 제외
//            //type = FilterType.ASSIGNABLE_TYPE, classes = {PaymentService.class}
//            // 2. 어노테이션 제외
//            //type = FilterType.ANNOTATION, classes = {org.springframework.stereotype.Service.class}
//            // 3. 정규표현식 제외  / 그나마 많이 씀 기껏 bean 만들고 제외 잘 안함
//            // type = FilterType.REGEX, pattern = {"com.wanted.di.section01.service.*"}
//    )
//)

//@ComponentScan (basePackages = "com.wanted.di.section01")

//@Component

@ComponentScan (basePackages = "com.wanted.di.section02",
    excludeFilters = @ComponentScan.Filter(

    )
)
public class AppConfig {
}