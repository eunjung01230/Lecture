import com.wanted.oop.b_oop.f_keyword.a_static.StaticFieldTest;

public class StaticCases {
    public static void main(String[] args) {

        // 경우 1: 같은 학생(st1)이 3번 긋기
        StaticFieldTest st1 = new StaticFieldTest();   // 새 공책 받기 (0)
        st1.increaseNonStatic();                       // 공책에 줄 1
        st1.increaseNonStatic();                       // 공책에 줄 2
        st1.increaseNonStatic();                       // 공책에 줄 3
        System.out.println("[경우1] st1 공책 : " + st1.getNonStaticInt());

        // 경우 2: 학생 3명이 한 번씩 긋기
        StaticFieldTest a = new StaticFieldTest();     // a 새 공책
        StaticFieldTest b = new StaticFieldTest();     // b 새 공책
        StaticFieldTest c = new StaticFieldTest();     // c 새 공책
        a.increaseNonStatic();                         // a 공책에 줄 1
        b.increaseNonStatic();                         // b 공책에 줄 1
        c.increaseNonStatic();                         // c 공책에 줄 1
        System.out.println("[경우2] a 공책 : " + a.getNonStaticInt()
                + ", b 공책 : " + b.getNonStaticInt()
                + ", c 공책 : " + c.getNonStaticInt());

        // 경우 3: 학생 3명이 칠판(static)에 한 번씩 긋기
        a.increaseStatic();                            // 칠판에 줄 1
        b.increaseStatic();                            // 같은 칠판에 줄 2
        c.increaseStatic();                            // 같은 칠판에 줄 3
        System.out.println("[경우3] 칠판 : " + StaticFieldTest.getStaticInt());

        // 경우 4: st1에 new를 또 하면?
        st1 = new StaticFieldTest();                   // 새 공책으로 바꿔치기!
        System.out.println("[경우4] new 다시 한 st1 공책 : " + st1.getNonStaticInt());
        System.out.println("[경우4] 칠판 : " + StaticFieldTest.getStaticInt());
    }
}
