package com.wanted.b_loop;

public class Application03 {
    public static void main(String[] args) {

        /* comment.
            for, while, do-while
            - 실행 코드를 최소 1회 실행 한 후
            - 조건식을 확인하는 반복문이다.
            형식 do { 실행 코드 } while(조건식);
        * */
        // 초기값
        int num = 5;
        do {
            // 반복 코드
            System.out.println("0~2까지 반복 출력 : " + num);
            // 증감식
            num++;
            // 조건식
        } while (num < 3);
    }
}
