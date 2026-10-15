package com.wanted.a_exception.b_solved;

public class Application {
    public static void main(String[] args) {

        System.out.println("프로그램 시작됨...");

        /* comment. 예외처리
            1. try - catch - finally
            - try : 예외가 발생할 가능성이 있는 코드 블럭
            - catch : 특정 예외를 처리하는 코드 블럭
            - finally : 예외 발생 여부와 관계없이 항상 실행되는 코드 블럭
            2. throws를 이용한 예외 전파

         */

        try {
            //예외 발생 가능성 있는 코드
            //int result = 10 / 0;  // new ArithmeticException();의 부모 RuntimeException를 넣어도 실행됨
            //NullPointerException
            String str = null;
            str.length(); //new NullPointerException(); Arith와 Null은 타입이 달라서 부모자식 안됨? 그래서 catch로 못감?
                            // 발생하는 예외타입에 따라 catch값을 분리해야함

        } catch (ArithmeticException e) {
            System.out.println("예외 메세지 = " + e.getMessage());
            System.out.println("❌❌❌예외 발생!!!!!!!❌❌❌");
        } catch (NullPointerException e) {
            System.out.println("예외 메세지 = " + e.getMessage());
            System.out.println("❌❌❌예외 발생!!!!!!!❌❌❌");
        } finally {
            System.out.println("예외 발생 여부와 관계 없이 실행됨");
        }
        //====================================================
        System.out.println("========================================================");
        
        try {
            checkAge(-10); //new Ille("나이는 음수일 수 없습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        

        System.out.println("프로그램 종료됨...");

    }

    public static void checkAge(int age) {
        if(age<0) {
            /* comment.
                실제로 예외를 발생시키는 메서드는 checkAge() 이다.
                throw는 해당 메서드에서 예외처리를 담당하는 것이 아닌
                부른쪽 (호출한 쪽) 에 예외처리를 위임한다고 보면 된다.
             */
            throw new IllegalArgumentException(
                    "나이는 음수일 수 없습니다."
            );
        }
        System.out.println("전달 받은 " + age + " 는 유효한 나이입니다.");
    }
}
