package com.wanted.servlet.i_filter;

// jakarta.servlet 확인해야함 종류가 많음
import jakarta.servlet.*;

import java.io.IOException;

/* comment.
    Filter를 등록하는 방법은 총 2가지이다.
    1. @WebFilter : 어노테이션 방식
    2. xml
 */
public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("인토딩 필터의 init() 호출됨..");
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        response.setContentType(encodingType);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
