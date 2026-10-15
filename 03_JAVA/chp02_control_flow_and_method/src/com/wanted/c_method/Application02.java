package com.wanted.c_method;

public class Application02 {
    public static void main(String[] args) {

        //1. 항상 main() 가 가장 먼저 동작을 한다.
        System.out.println("main() 시작됨...");

        //2. main() 영역 밖에 methodA() 추가한다.

        //5. 작성한 methodA를 호출할 준비
        Application02 app2 = new Application02();
        //6. 준비가 완료. 호출 시작 -> 메소드를 갔다가 무조건 호출이 시작된 곳으로 돌아옴
        app2.methodA();                  //.을 찍는 순간 메소드에 접근 -> 호출가능

        //7. methodA() 흐름 확인 후 methodB() 추가

        // end.
        System.out.println("main() 종료됨...");

    }

    //3. main() 영역에서 methodA() 호출 되는 지 확인
    public void methodA() {
        //void : 반환값이 없을 때 사용한다.

        //4. 호출 확인을 위한 출력 구문  -> 출력 더 이상 없으면 -> 무조건 호출이 시작된 곳으로 돌아옴
        System.out.println("methodA() 호출됨...");

        // return; // 회색인거는 void 되돌릴값이 없는데 왜 씀? 필요없다는 뜻

        //12. methodB() 호출 구문 작성  / ()는 무조건 호출
        methodB();

        //13. methodA() 종료 시점 출력
        System.out.println("methodA() 종료됨...");

    }

    //8. 호출 확인을 위한 methodB() 작성
    public void methodB() {
        //9. 호출 확인을 위한 출력 구문
        System.out.println("methodB() 호출됨...");

        //10. 작성 후 프로그램 시작하면?
        //methodB() 의 출력구문운 출력되지 않는다
        //Why? 부르질 않았는데 어떻게 나와요..

        //11. main() 영역이 아닌 methodA() 영역 내부에서 B 호출


    }
}
