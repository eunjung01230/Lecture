package com.wanted.c_method;

public class Calculator {

    /* comment.
        해당 계산기 클래스는
        +, -, %, /, *
        사칙연산을 잘하는 메소드를 모아 둔 클래스이다. / 메인없음
     */

    // 2개의 정수를 전달 받아 / 비교해서 / 최솟값을 반환하는 메서드
    // 전달 받는 정수를 담을 매개변수 2개 만들어야겠다!
    // 두 개의 매개변수를 대소 비교하는 코드 작성
    // 최솟값 ? 정수 ? int를 return 하면 되겠다~
    public int minNumber(int a, int b) {
        // 삼항연산자
        // a = 100, b = 20
        return (a > b) ? b : a; // return b;
    }

    public int maxNumberof(int a, int b) {
        // 삼항연산자
        // a = 100, b = 20
        return (a > b) ? a : b; // return b;
    }

}
