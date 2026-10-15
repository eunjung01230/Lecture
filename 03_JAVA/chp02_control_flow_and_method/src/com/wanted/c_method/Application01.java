package com.wanted.c_method;

public class Application01 {
    public static void main(String[] args) {

        /* comment. Method 가 없을 때 발생하는 문제
        * */
        // 1~10까지 두 수를 더하는 프로그램 ex) 1+2 = 3, 3+4 = 7 ...
        int num1 = 1;
        int num2 = 2;
        System.out.println("1번째 연산 결과 : " + (num1 + num2));

        int num3 = 3;
        int num4 = 4;
        System.out.println("2번째 연산 결과 : " + (num3 + num4));

        // 위 프로그램의 문제는 2개의 수를 더하고 싶을 때마다
        // 변수 코드 2줄 , 연산 및 출력 코드 1줄 이 무한 반복이 된다.

        /* comment method 호출 방법
            클래스명 변수명 = new 클래스명();
            변수명. 메소드명(); <- 호출하는 방법  // 다음챕터에 더 자세히
         */

        //Application01 을 활용 준비하는 구문
        //클래스는 자료형이 될 수 있다. ex) int 등등
        Application01 app = new Application01();
        // 점. = 참조연산자 / 내부로 그 안으로 들어간다 참조한다.
//        app.sumTwoNumber();  app.점을 찍으면 main밖에 만들어 놓은 메서드가 불러지고 길이됨을 통해 안으로 관여가 가능해진다.

        //int x = 10;
        //int short long double float boolean byte char

        // () -> 프로그래밍에서의 소괄호의 의미
        // 함수(메서드) 를 호출하는 의미

        System.out.println("3번째 연산: " + app.sumTwoNumber(5,6));
        System.out.println("4번째 연산: " + app.sumTwoNumber(7,8));
        System.out.println("5번째 연산: " + app.sumTwoNumber(9,10));
    }
    //===================main 영역 외부=========================//
    /* comment.
    *   메소드란? (반복적인 작업을 코드로 정리한것)
    *   특정 작업을 수행하는 코드블럭이다.
    *   코드의 재사용성과 가독성을 향상시키기 위해
    *   사용이 되며, 프로그램의 구조를 체계적으로 만들고,
    *   유지보수를 용이하게 한다. (= 연산마다 바꿔야하는 것을 매소드의 규칙한번 바꾸는 걸로 해결 가능)
    *   형식
    *   [접근제어자] [반환 타입] 메소드명([매개변수 타입 매개변수 명]) {
    *       실행 할 코드
    *       [ return 반환값;]
    *   }
    * */
    public int sumTwoNumber(int a, int b) {
        return a + b;
    }
    //===================main 영역 외부=========================//
}

