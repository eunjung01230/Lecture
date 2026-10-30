package com.wanted.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimerInterceptor implements HandlerInterceptor {
    // Interceptor는 Controller의 핸들러 메서드 전과 후에 동작한다.

    // Controller 도달 전에 동작
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle() 동작함");

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);

        // true : 다음 인터셉터가 있다면 호출 / 없다면 컨트롤러의 핸들러 메서드 호출
        return true;
    }

    // Controller 핸들러메서드 실행 후에 동작
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

        System.out.println("postHandler() 호출됨");

        long endTime = System.currentTimeMillis();

        long startTime = (long) request.getAttribute("startTime");

        modelAndView.addObject("interval", endTime - startTime);

    }
}
