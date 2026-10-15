package com.wanted.c_operator;

public class Application {

    public static void main(String[] args) {

        // 연산자 테스트용
        int a = 10;
        int b = 3;

        /* comment. 연산자
        *   산술연산
        *   - (+, - , * , %, / )
        *   - % 프로그래밍에서는 모드 연산 이라는
        *   - 것이 추가된다. 나머지를 구하는 연산자
        * */

        // "안녕" + 3 -> 문자열 + 숫자
        // 문자열이 포함 된 더하기 연산은 유의해야 한다.
        // 문자열은 + 연산을 만나면 피연산자를 문자열로 변환한다.
        System.out.println("덧셈 : " + (a + b));
        System.out.println("나눗셈 : " + (a / b));
        System.out.println("나머지 : " + (a % b));

        /* comment. 비교연산
        *   두 값을 비교하여 참 / 거짓을 반환하는 연산자
        *   - ( == , != , < , > , <= , >= )
         */

        boolean isGreater = a > b;

        System.out.println("a > b : " + (a > b));
        //프로그래밍에서 ! 의 의미는 NOT
        // a <= b 이하를 의미
        System.out.println("a != b : " + (a != b));

        /* comment. 논리연산
        *   하나 이상의 "조건을 결합" 하여 최종적인
        *   참 또는 거짓을 평가한다.
        *   - ( &&(and) , ||(or), !(not) )
         */

        boolean isTrue = true;
        boolean isFalse = false;

        /* comment.
        *   과거 && 연산관련 된 면접 질문
        *    A && B 식이 있을 때 A 가 앞에 오는 것과 B 가 앞에 오는 것에 대한 고찰
         */

        System.out.println("둘다 참이니? : " + (isFalse && isTrue));
        System.out.println("둘 중 하나는 참이니? : " + (isFalse || isTrue));

        /* comment. 증감 연산
        *   변수의 값을 1씩 증가 시키거나 감소 시키는 연산자
        *   ++(증가) , --(감속)
        *   전위 연산, 후위 연산
         */

        int age = 20;

        System.out.println("초기 값 age : " + (age)); //20
        System.out.println("++age : " + (++age));  //21 전위연산은 시작하기 전에 더하기를 먼저
        System.out.println("age : " + (age));  //21
        System.out.println("age++ : " + (age++));  //21 후위연산은 출력시 한줄의 코드가 끝나 후에 연산 진행
        System.out.println("age : " + (age));  //22

    }
}
