package com.wanted.aop.section01;

import java.lang.reflect.Member;

public class Application {

    /* comment.
        주제: 회원 관리 프로그램
        기능: 회원가입, 회원조회, 비밀번호 수정, 탈퇴
        비기능: 로깅, 성능측정
     */
    public static void main(String[] args) {
        System.out.println("=============AOP 적용 전=============");

        MemberService service = new MemberService();

        System.out.println("[테스트 1] 회원 가입");
        service.registerMember();

        System.out.println("=============AOP 적용 전=============");

    }
}
