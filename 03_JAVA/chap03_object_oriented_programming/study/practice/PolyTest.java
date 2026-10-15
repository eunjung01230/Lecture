interface Animal {                    // 약속 카드: 이건 꼭 할 수 있어야 해요
    void bark();
}

class Raccoon implements Animal {     // 너구리: "약속 지킬게요!"
    @Override
    public void bark() { System.out.println("너구리: 캥캥!"); }
    public void bite() { System.out.println("너구리: 앙 깨물기!"); }
}

class Koala implements Animal {       // 코알라: "저도 지킬게요!"
    @Override
    public void bark() { System.out.println("코알라: 끄응~"); }
}

public class PolyTest {
    public static void main(String[] args) {
        // Animal a = new Animal();   // ❌ 약속 카드로는 동물을 만들 수 없어요

        Animal a1 = new Raccoon();    // 너구리를 "동물" 이름표로 부르기
        Animal a2 = new Koala();      // 코알라도 "동물" 이름표로 부르기

        Animal[] animals = { a1, a2 };
        for (Animal a : animals) {
            a.bark();                 // 똑같이 bark() 한 번 → 각자 다르게!
        }

        // a1.bite();                 // ❌ "동물" 이름표에는 bite가 없어요
        ((Raccoon) a1).bite();        // ✅ 너구리 이름표로 바꿔 달면 OK
    }
}
