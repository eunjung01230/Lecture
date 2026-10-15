class MyFieldTest {
    private int nonStaticInt;

    public MyFieldTest() {}                        // 기본 생성자: 0으로 시작
    public MyFieldTest(int start) {                // 원하는 숫자로 시작
        this.nonStaticInt = start;
    }

    public int getNonStaticInt() { return nonStaticInt; }
    public void increaseNonStatic() { this.nonStaticInt++; }

    public void resetNonStatic() {                 // 공책 지우개
        this.nonStaticInt = 0;
    }
    public void setNonStaticInt(int value) {       // 원하는 숫자로 고쳐 쓰기
        this.nonStaticInt = value;
    }
}

public class ResetTest {
    public static void main(String[] args) {
        // 방법 1: new 다시 하기
        MyFieldTest st1 = new MyFieldTest();
        st1.increaseNonStatic();
        st1.increaseNonStatic();
        System.out.println("[방법1] new 전 : " + st1.getNonStaticInt());
        st1 = new MyFieldTest();
        System.out.println("[방법1] new 후 : " + st1.getNonStaticInt());

        // 방법 2: 지우개 메소드
        MyFieldTest st2 = new MyFieldTest();
        st2.increaseNonStatic();
        st2.increaseNonStatic();
        System.out.println("[방법2] 지우기 전 : " + st2.getNonStaticInt());
        st2.resetNonStatic();
        System.out.println("[방법2] 지운 후   : " + st2.getNonStaticInt());

        // 방법 3: setter로 원하는 숫자 넣기
        st2.setNonStaticInt(10);
        System.out.println("[방법3] set(10) 후 : " + st2.getNonStaticInt());

        // 방법 4: 생성자로 처음부터 원하는 숫자
        MyFieldTest st3 = new MyFieldTest(5);
        System.out.println("[방법4] new MyFieldTest(5) : " + st3.getNonStaticInt());
    }
}
