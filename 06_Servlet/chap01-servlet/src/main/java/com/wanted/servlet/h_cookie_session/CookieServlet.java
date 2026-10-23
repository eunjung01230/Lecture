package com.wanted.servlet.h_cookie_session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 쿠키에 담을 사용자의 입력값 추출
        String cookieValue = req.getParameter("cookieValue");

        // 쿠키 객체 생성!
        Cookie cookie = new Cookie("userValue", cookieValue);
        cookie.setMaxAge(60 * 60); // 만료 시간 설정  60 * 60 = 한시간 60 * 60 * 24 = 하루

        //브라우저에게 보내줄 쿠키 add
        resp.addCookie(cookie);

        doGet(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //해당 doGet() 메서드는 doPost() 요청 후 응답 시 사용되는 메서드
//        resp.setContentType("text/html; charset=UTF-8");

        String savedValue = "없음!";

        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userValue".equals(cookie.getName())) {
                    savedValue = cookie.getValue();
                    break;
                }
            }
        }

        // 쿠키에 있는 값을 화면에 보여주기 위해 넣어주기
        req.setAttribute("savedValue", savedValue);

        RequestDispatcher rd = req.getRequestDispatcher(
                "/h_cookie_session/cookie-result.jsp"
        );
        rd.forward(req,resp);
    }
}


