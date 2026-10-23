package com.wanted.servlet.h_cookie_session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    /* comment.
        dopost() : 사용자의 입력 id, pwd를 세션에 저장 및 유효시간 지정
        doget() : 세션에 저장 된 값을 꺼내고 응답 전용 JSP로 forward
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // true: 세션 만든다.
        // false: 기존의 세션을 활용하며, 없다면 null 반환
        HttpSession session = req.getSession(false);

        String loggedInUser = null;
        String pwd = null;

        if (session != null) {
            loggedInUser = session.getAttribute("loggedInUser").toString();
            pwd = session.getAttribute("userPwd").toString();
        }

        req.setAttribute("loggedInUser", loggedInUser != null ? loggedInUser : "로그인 안됨!!");
        req.setAttribute("pwd", pwd != null ? pwd : "비밀번호 없음..");

        RequestDispatcher rd = req.getRequestDispatcher(
                "/h_cookie_session/session-result.jsp"
        );

        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인 버튼을 불렀을 때
        // ID, PWD를 req에서 꺼내서 변수에 담기
        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");

        if(userId != null && !userPwd.isEmpty()) {
            // 사용자의 아이디와 비밀번호를 저장하기 위한 Session 객체 생성
            HttpSession session = req.getSession(true);  //HttpSession은 인터페이스니까 req에서 가져와야함
            // 동일한 사용자인지를 확인하기 위한 변수 생성.
            //String existUser = session.getAttribute("loggedInUser").toString(); null에 점을 찍고 변환 = null을 참조 오류 펑
            //null 발생 여부가 존재하는 변수를 형변환 시 메서드로 형변환 하는 것 보다
            // () : 캐스트 연산자 == 형변환 연산자를 사용하는 것이 안정적이다. 명시적을 쓰면 .을 안찍어서 그냥 null이라는 문자열이 됨
            String existUser = (String) session.getAttribute("loggedInUser"); //명시적 형변환으로 바꿈 null되기 전에 변환

            if(existUser == null || existUser.equals(userId)) {
                session.setAttribute("loggedInUser", userId);
                if(userPwd != null && !userPwd.isEmpty()) {
                    session.setAttribute("userPwd", userPwd);
                }
                session.setMaxInactiveInterval(30); // session 의 유효 기간 설정 30초!
            } else {
                session.setAttribute("loggedInUser", userId);
                if(userPwd != null && !userPwd.isEmpty()) {
                    session.setAttribute("userPwd", userPwd);
                }
                session.setMaxInactiveInterval(30);
            }

            doGet(req, resp);

        }

    }
}



//if (userId !=null && !userPwd.isEmpty()) {
////사용자 ID, PWD를 Session에 저장하기 위한
////Seseion 객체 생성
//HttpSession session = req.getSession(true); //HttpSession은 인터페이스니까 req에서 가져와야함
//
////동일한 사용자인지를 확인하기 위한 변수 생성
//String existUser = session.getAttribute("loggedInUser").toString();
//
//            if (existUser == null || existUser.equals(userId)) {
//        session.setAttribute("loggedInUser", userId);
//            } }
