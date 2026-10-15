package com.wanted.b_loop;

public class Application01 {
    public static void main(String[] args) {
        /* comment. for 문 (반복문)
            for 문은 초기값, 조건식, 증감식을 사용해서 반복의 횟수를 제어하는 반복문이다.
            형식
            for(초기식; 조건식; 증감식;) { 실행 코드 }
            초기식: 반복되는 변수의 초기값 설정
            조건식: true 일 때 반복, false 일 때 종료되는 조건 설정
            증감식: 1회 반복 후 변수의 값을 변경
        * */

        /* 성원인가 벤치프레스를 5번 반복하는 프로그램 */
        System.out.println("성원님 벤치프레스 5회 실시할게요~");
        //for(초기식; 조건식; 증감식;) { 실행 코드 }
        //초기식: int x = 1;
        //조건식 : x <= 5;
        //증감식 : x++
        //실행 : sout("성원님" + x + "번 했습니다~.");
        for (int i = 1; i <= 5; i++) {

            /* 프로그램 추가 조건
                헬스트레이너는 성원님이 홀수번 할때만 말해주고
                짝수번 할때는 침묵한다. 침묵 시에는 sout("침묵함...");
                구문을 출력한다.
                - 짝수 판단 방법: 짝수는 2의 배수이다. 2로 나누면 나머지가 0
             */
            if (i % 2 == 0) {
                System.out.println("침묵함...");
            } else {
                System.out.println("성원님 " + i + "번 했습니다~");  // 짝수 조건을 추가할때 안으로 집어넣어라
            }
        }
//        System.out.println("성원님 1번 했습니다~");
//        System.out.println("성원님 2번 했습니다~");
//        System.out.println("성원님 3번 했습니다~");
//        System.out.println("성원님 4번 했습니다~");
//        System.out.println("성원님 5번 했습니다~");
    }
}
