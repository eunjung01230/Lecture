import com.wanted.oop.b_oop.f_keyword.a_static.StaticFieldTest;

public class StaticAccumulate {
    public static void main(String[] args) {
        StaticFieldTest st1 = new StaticFieldTest();
        st1.increaseStatic();
        st1.increaseStatic();
        st1.increaseStatic();
        st1.increaseNonStatic();
        st1.increaseNonStatic();
        st1.increaseNonStatic();
        System.out.println("[객체 1개로 3번] st1 non-static : " + st1.getNonStaticInt());
        System.out.println("[객체 1개로 3번] static         : " + StaticFieldTest.getStaticInt());

        StaticFieldTest st2 = new StaticFieldTest();
        st2.increaseNonStatic();
        st2.increaseStatic();
        StaticFieldTest st3 = new StaticFieldTest();
        System.out.println("[질문 코드] st3 non-static : " + st3.getNonStaticInt());
        System.out.println("[질문 코드] static         : " + StaticFieldTest.getStaticInt());
    }
}
